package com.eni.superhero.service;

import java.util.List;

import com.eni.superhero.bean.Product;

public interface ProductService {
	public List<Product> createAllProducts();
	public List<Product> testCreationProducts();
	public String demoForTest(Integer value);
	public List<Product> findByStockLessThan(int secureLimitStock);
	public List<Product> getAllProductWithPriceMoreThanParam(double priceCondition, List<Product> productList);
	public double sumAllPriceProduct(List<Product> productList);
	public int calculateOperation(int oldValue, int valueOperation, String operationType);
}
