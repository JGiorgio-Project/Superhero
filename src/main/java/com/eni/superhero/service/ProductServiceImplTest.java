package com.eni.superhero.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.eni.superhero.bean.Product;

public class ProductServiceImplTest {
	
	@Test
	void testDemoForTestThenReturnOK() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		Integer value = 15;
		
		// WHEN : On appelle la méthode
		String result = productService.demoForTest(value);
		
		// THEN : On verifie le resultat
		assertEquals("OK", result);
	}
	
	@Test
	void testDemoForTestThenReturnKO() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		Integer value = 5;
		
		// WHEN : On appelle la méthode
		String result = productService.demoForTest(value);
		
		// THEN : On verifie le resultat
		assertEquals("KO", result);
	}
	
	@Test
	void testDemoForTestWithExxactValueThenReturnKO() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		Integer value = 10;
		
		// WHEN : On appelle la méthode
		String result = productService.demoForTest(value);
		
		// THEN : On verifie le resultat
		assertEquals("KO", result);
	}
	
	@Test
	void testDemoForTestWithNegativeValueThenReturnKO() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		Integer value = -99;
		
		// WHEN : On appelle la méthode
		String result = productService.demoForTest(value);
		
		// THEN : On verifie le resultat
		assertEquals("KO", result);
	}
	
	@Test
	void testDemoForTestWithNullValueThenReturnKO() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		Integer value = null;
		
		// WHEN : On appelle la méthode
		String result = productService.demoForTest(value);
		
		// THEN : On verifie le resultat
		assertEquals("KO", result);
	}
	
	//###############################################################################
	//##########################   calculateOperation     ###########################
	//###############################################################################
	
	@Test
	void testCalculateOperationThenReturnSum() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		int oldValue = 5;
		int valueOperation = 5;
		String operationType = "plus";
		
		// WHEN : On appelle la méthode
		int result = productService.calculateOperation(oldValue, valueOperation, operationType);
		
		// THEN : On verifie le resultat
		assertEquals(oldValue+valueOperation, result);
	}
	
	@Test
	void testCalculateOperationThenReturnProduct() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		int oldValue = 5;
		int valueOperation = 5;
		String operationType = "product";
		
		// WHEN : On appelle la méthode
		int result = productService.calculateOperation(oldValue, valueOperation, operationType);
		
		// THEN : On verifie le resultat
		assertEquals(oldValue*valueOperation, result);
	}
	
	@Test
	void testCalculateOperationWhenOperationTypeIsEmptyStringThenReturnNegativOne() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		int oldValue = 5;
		int valueOperation = 5;
		String operationType = "";
		
		// WHEN : On appelle la méthode
		int result = productService.calculateOperation(oldValue, valueOperation, operationType);
		
		// THEN : On verifie le resultat
		assertEquals(-1, result);
	}
	
	@Test
	void testCalculateOperationWhenOperationTypeIsAnotherWordStringThenReturnNegativOne() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		int oldValue = 5;
		int valueOperation = 5;
		String operationType = "toto";
		
		// WHEN : On appelle la méthode
		int result = productService.calculateOperation(oldValue, valueOperation, operationType);
		
		// THEN : On verifie le resultat
		assertEquals(-1, result);
	}
	
	@Test
	void testCalculateOperationWhenOperationTypeIsSpaceStringThenReturnNegativOne() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		int oldValue = 5;
		int valueOperation = 5;
		String operationType = " ";
		
		// WHEN : On appelle la méthode
		int result = productService.calculateOperation(oldValue, valueOperation, operationType);
		
		// THEN : On verifie le resultat
		assertEquals(-1, result);
	}
	
	@Test
	void testCalculateOperationWhenOperationTypeIsNullThenReturnNegativOne() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		int oldValue = 5;
		int valueOperation = 5;
		String operationType = null;
		
		// WHEN : On appelle la méthode
		int result = productService.calculateOperation(oldValue, valueOperation, operationType);
		
		// THEN : On verifie le resultat
		assertEquals(-1, result);
	}
	
	
	//###############################################################################
	//#########################   sumAllPriceProduct    ###########################
	//###############################################################################
	
	@Test
	void testSumAllPriceProductThenReturntotal() {
		// GIVEN : On fourni toutes les variables qu'il faut pour appeler la méthode
		ProductService productService = new ProductServiceImpl();
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product(1, "Banane", 1.25d, 10));
		productList.add(new Product(2, "Boeuf", 3.3d, 15));
		productList.add(new Product(3, "Cerise", 2.1d, 30));
		productList.add(new Product(4, "Fraise", 1.8d, 45));
		productList.add(new Product(5, "Framboise", 1.5d, 10));
		productList.add(new Product(6, "Porc", 2.5d, 20));
		productList.add(new Product(7, "Poireaux", 3d, 30));
		productList.add(new Product(8, "Salade", 1.5d, 5));
		
		
		// WHEN : On appelle la méthode
		double result = productService.sumAllPriceProduct(productList);
		
		// THEN : On verifie le resultat
		assertEquals(368.5, result);
	}
	
	
	
	
	
	
}
