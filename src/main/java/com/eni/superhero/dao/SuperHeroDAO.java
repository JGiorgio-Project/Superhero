package com.eni.superhero.dao;

import org.springframework.data.repository.CrudRepository;

import com.eni.superhero.bean.SuperHero;

public interface SuperHeroDAO extends CrudRepository<SuperHero, Integer> {
	
}
