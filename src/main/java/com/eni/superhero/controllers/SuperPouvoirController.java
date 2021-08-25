package com.eni.superhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eni.superhero.bean.SuperPouvoir;
import com.eni.superhero.dao.SuperPouvoirDAO;
import com.eni.superhero.service.SuperPouvoirService;

@RestController
@RequestMapping("superpouvoir")
public class SuperPouvoirController {
	@Autowired
	SuperPouvoirService superPouvoirService;
	@Autowired
	SuperPouvoirDAO superPouvoirDAO;
	
	
	@GetMapping("/add")
	public ModelAndView superPouvoir(String filterPouvoirByNameForm) {
		ModelAndView mav = new ModelAndView("superPouvoir");
		mav.addObject("pouvoirForm", new SuperPouvoir());
		mav.addObject("deletePouvoirForm", new SuperPouvoir());
		if(filterPouvoirByNameForm == null) {
			List<SuperPouvoir> listPouvoirs = superPouvoirService.findall();
			mav.addObject("listPouvoirs", listPouvoirs);
		}else {
			List<SuperPouvoir> listPouvoirs = superPouvoirService.findBySuperPouvoirContains(filterPouvoirByNameForm);
			mav.addObject("listPouvoirs", listPouvoirs);
		}
		
		return mav;
	}
	
	@PostMapping("create-pouvoir-form-mvc")
	public ModelAndView createPouvoirFormMvc(@ModelAttribute("pouvoirForm") SuperPouvoir pouvoirForm) {
		// Traitement des données du formulaire
		System.out.println(pouvoirForm);
		
		superPouvoirService.createOrUptdate(pouvoirForm);
		
		return superPouvoir("");
	}
	
	@PostMapping("delete-pouvoir-form-mvc")
	public ModelAndView deletePouvoirFormMvc(@ModelAttribute("deletePouvoirForm") SuperPouvoir deletePouvoirForm) {
	
		superPouvoirService.delete(deletePouvoirForm.getId());
		
		return superPouvoir("");
	}
	
	@PostMapping("filter-pouvoir-name-form")
	public ModelAndView filterPouvoirByNameForm(String filterPouvoirByNameForm) {
		return superPouvoir(filterPouvoirByNameForm);
	}
}
