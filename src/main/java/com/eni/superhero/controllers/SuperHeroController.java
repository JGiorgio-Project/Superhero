package com.eni.superhero.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eni.superhero.bean.Category;
import com.eni.superhero.bean.SuperHero;
import com.eni.superhero.bean.SuperPouvoir;
import com.eni.superhero.dao.SuperHeroDAO;
import com.eni.superhero.service.CategoryService;
import com.eni.superhero.service.SuperHeroService;
import com.eni.superhero.service.SuperPouvoirService;

@RestController
@RequestMapping("superhero")
public class SuperHeroController {
	@Autowired
	SuperHeroService superHeroService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SuperPouvoirService superPouvoirService;
	@Autowired
	SuperHeroDAO superHeroServiceDAO;
	

	@GetMapping("/list")
	public ModelAndView heroList() {
		ModelAndView mav = new ModelAndView("heroList");
		List<SuperHero> listSuperHeros = superHeroService.findall();
		mav.addObject("listSuperHeros", listSuperHeros);
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView heroDetail(Integer id) {
		ModelAndView mav = new ModelAndView("heroDetail");
		SuperHero superHero = superHeroService.findById(id);
		mav.addObject("deleteHeroForm", superHero);
	
		mav.addObject("superHero", superHero);
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView heroCreate(SuperHero heroForm) {
		ModelAndView mav = new ModelAndView("heroCreate");
		

		List<Category> listCategories = categoryService.findall();
		List<SuperPouvoir> listSuperPouvoirs = superPouvoirService.findall();
		
		mav.addObject("listCategories", listCategories);
		mav.addObject("listSuperPouvoirs", listSuperPouvoirs);
		
		if (heroForm == null) {
			mav.addObject("heroForm", new SuperHero());
		} else {
			mav.addObject("heroForm", heroForm);
		}
		
		return mav;
	}
	

	@PostMapping("create-form-mvc")
	public ModelAndView createFormMvc(@ModelAttribute("heroForm") @Valid SuperHero heroForm,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return heroCreate(heroForm);
		} else {
			superHeroService.createOrUptdate(heroForm);
			
			return heroCreate(null);
		}
	}
	
	@PostMapping("delete-hero-form-mvc")
	public ModelAndView deleteHeroFormMvc(@ModelAttribute("deleteHeroForm") SuperHero deleteHeroForm) {
		superHeroService.delete(deleteHeroForm.getId());
		
		return heroList();
	}
}
