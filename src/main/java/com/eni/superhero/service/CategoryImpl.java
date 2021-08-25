package com.eni.superhero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eni.superhero.bean.Category;
import com.eni.superhero.dao.CategoryDAO;

@Service
public class CategoryImpl implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public Category createOrUptdate(Category category) {
		return categoryDAO.save(category);
	}

	@Override
	@Transactional
	public void delete(int id) {
		categoryDAO.deleteById(id);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findall() {
		
		return (List<Category>) categoryDAO.findAll();
	}

	

}
