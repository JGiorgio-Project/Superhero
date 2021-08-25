package com.eni.superhero.data;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.eni.superhero.bean.Category;
import com.eni.superhero.bean.Combat;
import com.eni.superhero.bean.SuperHero;
import com.eni.superhero.bean.SuperPouvoir;
import com.eni.superhero.dao.CategoryDAO;
import com.eni.superhero.dao.CombatDAO;
import com.eni.superhero.dao.SuperHeroDAO;
import com.eni.superhero.dao.SuperPouvoirDAO;

@Component
public class DemoData {
	@Autowired
    private CategoryDAO categoryDAO;
	@Autowired
    private SuperPouvoirDAO superPouvoirDAO;
	@Autowired
    private SuperHeroDAO superHeroDAO;
	@Autowired
	CombatDAO combatDAO;
	
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	
    	Category gentil = new Category("Gentil");
		Category mechant = new Category("Méchant");
		Category gentilMechant = new Category("Gentil/Méchant");
		categoryDAO.save(gentil);
		categoryDAO.save(mechant);
		categoryDAO.save(gentilMechant);
		
		SuperPouvoir dusse = new SuperPouvoir("Sur un mal entendu ça peut marcher!");
		SuperPouvoir faux = new SuperPouvoir("C'est pas faux!");
		SuperPouvoir courgette = new SuperPouvoir("Fait apparaitre des courgettes");
		superPouvoirDAO.save(dusse);
		superPouvoirDAO.save(faux);
		superPouvoirDAO.save(courgette);
    	
		
		SuperHero Peper = new SuperHero( "Perceval", "De Galle","Peper", gentil, new ArrayList<>(List.of(faux, courgette)), LocalDate.of(1985, 05, 22), null);
		SuperHero Janeau = new SuperHero( "Jean-Claude", "Dusse","Janeau", mechant, new ArrayList<>(List.of(dusse)), LocalDate.of(1985, 05, 22), null);
		SuperHero Souplet = new SuperHero( "Leg", "Hume", "Souplet", gentilMechant, new ArrayList<>(List.of(faux, dusse)), LocalDate.of(1985, 05, 22), null);
    	superHeroDAO.save(Peper);
    	superHeroDAO.save(Janeau);
    	superHeroDAO.save(Souplet);
    	
    	Combat combat1 = new Combat("Combat 01",new ArrayList<>(List.of(Peper, Janeau)));
    	Combat combat2 = new Combat("Combat 02",new ArrayList<>(List.of(Souplet, Janeau)));
    	combatDAO.save(combat1);
    	combatDAO.save(combat2);
    	
    }
}
