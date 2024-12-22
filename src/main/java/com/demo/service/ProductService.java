package com.demo.service;

import java.util.List;

import com.demo.entities.Products;

public interface ProductService {
	
	Products createProducts(Products product, int categoryId);
	Products updateProducts(Products product, Integer productId);
	Products getProductBId(Integer productId);

	List<Products> getProductsByCategoryId(int categoryId);
	void deleteCProducts(Integer productId);
	
	List<Products> getproducts();
	Products getProductByProductId(int productId);

}
