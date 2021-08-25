package com.eni.superhero.dao;

import org.springframework.data.repository.CrudRepository;

import com.eni.superhero.bean.Category;

public interface CategoryDAO extends CrudRepository<Category, Integer> {

}
