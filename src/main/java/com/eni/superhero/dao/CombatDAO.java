package com.eni.superhero.dao;

import org.springframework.data.repository.CrudRepository;

import com.eni.superhero.bean.Combat;

public interface CombatDAO extends CrudRepository<Combat, Integer> {

}
