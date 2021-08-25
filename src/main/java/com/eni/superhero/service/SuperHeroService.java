package com.eni.superhero.service;

import java.util.List;

import com.eni.superhero.bean.SuperHero;

public interface SuperHeroService {
	public SuperHero createOrUptdate(SuperHero superHero);
	public void delete(int id);
	public SuperHero findById(int id);
	public List<SuperHero> findall();
}
