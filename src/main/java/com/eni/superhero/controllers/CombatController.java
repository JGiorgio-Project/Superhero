package com.eni.superhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eni.superhero.bean.Combat;
import com.eni.superhero.service.CombatService;

@RestController
@RequestMapping("combat")
public class CombatController {
	@Autowired
	CombatService combatService;
	
	@GetMapping("")
	public ModelAndView combat() {
		ModelAndView mav = new ModelAndView("combat");
		
		List<Combat> listCombats = combatService.findall();
		mav.addObject("listCombats", listCombats);
	
		return mav;
	}

}
