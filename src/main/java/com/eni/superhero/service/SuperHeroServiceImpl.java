package com.eni.superhero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eni.superhero.bean.SuperHero;
import com.eni.superhero.dao.SuperHeroDAO;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
	@Autowired
	SuperHeroDAO superHeroDAO;
	
	@Override
	@Transactional
	public SuperHero createOrUptdate(SuperHero superHero) {
	
		return superHeroDAO.save(superHero);
	}

	@Override
	@Transactional
	public void delete(int id) {
		superHeroDAO.deleteById(id);
	}

	@Override
	public SuperHero findById(int id) {
		Optional<SuperHero> superHero = superHeroDAO.findById(id);
		if(superHero.isPresent()) {
			return superHero.get();
		}else {
			// TODO : gerer les erreurs
			return null;
		}
	}

	@Override
	public List<SuperHero> findall() {
		
		return (List<SuperHero>) superHeroDAO.findAll();
	}	
}
