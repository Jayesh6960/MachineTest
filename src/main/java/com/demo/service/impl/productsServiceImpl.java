package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Categories;
import com.demo.entities.Products;
import com.demo.exception.ResourseNotFoundException;
import com.demo.repo.CategoriesRepo;
import com.demo.repo.ProductsRepo;
import com.demo.service.ProductService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class productsServiceImpl implements ProductService{
	
	@Autowired
	private ProductsRepo productsRepo;
	
	@Autowired
	private CategoriesRepo categoriesRepo;

	@Override
	public Products createProducts(Products product, int categoryId) {
		Categories exitcategory = categoriesRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category", "categoryId", categoryId));
		product.setCategory(exitcategory);
		return productsRepo.save(product);
	}

	@Override
	public Products getProductBId(Integer productId) {
		
		return productsRepo.findById(productId).orElseThrow(()-> new ResourseNotFoundException("product", "productId", productId));
	}

	@Override
	public List<Products> getProductsByCategoryId(int categoryId) {
		
		return productsRepo.findByCategory_CategoryId(categoryId);
	}

	@Override
	public List<Products> getproducts() {
		
		return productsRepo.findAll();
	}

	@Override
	public Products getProductByProductId(int productId) {
		
		return productsRepo.findById(productId).orElseThrow(()-> new ResourseNotFoundException("products", "productsId", productId));
	}

	@Override
	public Products updateProducts(Products product, Integer productId) {
		Products exitproduct= productsRepo.findById(productId).orElseThrow(()-> new ResourseNotFoundException("product", "productsId", productId));
		exitproduct.setProductName(product.getProductName());
		exitproduct.setProductPrice(product.getProductPrice());
		exitproduct.setProductDescription(product.getProductDescription());
		
		return productsRepo.save(exitproduct);
	}

	@Override
	public void deleteCProducts(Integer productId) {
		Products products= productsRepo.findById(productId).orElseThrow(()-> new ResourseNotFoundException("product", "productsId", productId));
		productsRepo.delete(products);
		
	}


}
