package com.eni.superhero.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eni.superhero.bean.SuperPouvoir;


public interface SuperPouvoirDAO extends CrudRepository<SuperPouvoir, Integer> {
	public List<SuperPouvoir> findBySuperPouvoirContains(String superPouvoir);
}
