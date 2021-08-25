package com.eni.superhero.service;

import java.util.List;

import com.eni.superhero.bean.Category;

public interface CategoryService {
	public Category createOrUptdate(Category category);
	public void delete(int id);
	public Category findById(int id);
	public List<Category> findall();
}
