package com.eni.superhero.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eni.superhero.bean.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {
	public List<Product> findByStockLessThan(int secureLimitStock);
}
