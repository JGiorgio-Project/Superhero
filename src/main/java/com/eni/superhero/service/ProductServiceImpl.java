package com.eni.superhero.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eni.superhero.bean.Product;
import com.eni.superhero.dao.ProductDAO;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	public List<Product> createAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product(1, "Banane", 1.25d, 10));
		productList.add(new Product(2, "Boeuf", 3.3d, 15));
		productList.add(new Product(3, "Cerise", 2.1d, 30));
		productList.add(new Product(4, "Fraise", 1.8d, 45));
		productList.add(new Product(5, "Framboise", 1.5d, 10));
		productList.add(new Product(6, "Porc", 2.5d, 20));
		productList.add(new Product(7, "Poireaux", 3d, 30));
		productList.add(new Product(8, "Salade", 1.5d, 5));
		return productList;
	}
	
	@Override
	public List<Product> testCreationProducts() {
		return createAllProducts();
	}
	
	@Override
	public String demoForTest(Integer value) {
		if (value != null && value > 10) {
			return "OK";
		} else {
			return "KO";
		}
	}
	
	
	public int calculateOperation(int oldValue, int valueOperation, String operationType) {
		int finalResult = 0;
		
		if (operationType != null && operationType.equalsIgnoreCase("plus")) {
			finalResult = oldValue + valueOperation;
		} else if (operationType != null && operationType.equalsIgnoreCase("product")) {
			finalResult = oldValue * valueOperation;
		} else {
			finalResult = -1;
		}
		
		return finalResult;
	}

	public List<Product> getAllProductWithPriceMoreThanParam(double priceCondition, List<Product> productList) {
		List<Product> newProductList = new ArrayList<Product>();
		for (Product product : productList) {
			if (product.getPrice() > priceCondition) {
				newProductList.add(product);
			}
		}
		return newProductList;
	}

	
	
	
	public double sumAllPriceProduct(List<Product> productList) {
		double totalPrice = 0d;
		
		for (Product product : productList) {
			totalPrice += product.getPrice() * product.getStock();
		}
		
		return totalPrice;
	}
	
	
	
	@Override
	public List<Product> findByStockLessThan(int secureLimitStock) {
		return productDAO.findByStockLessThan(secureLimitStock);
	}


}
