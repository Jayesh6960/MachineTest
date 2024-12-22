package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Products;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping(value="/{categoryId}")
	public Products createProduct(@PathVariable int categoryId, @RequestBody Products products) {
		
		return productService.createProducts(products, categoryId);
		
	}
	
	@GetMapping(value = "/{categoryId}")
	public List<Products> getAllProduct(@PathVariable int categoryId){
		return productService.getProductsByCategoryId(categoryId);
	}
	
	@GetMapping(value="/")
	public List<Products> getProducts(){
		
		return productService.getproducts();
		
	}
	
	@GetMapping(value="/product/{productId}")
	public Products getProductById(@PathVariable int productId) {
		return productService.getProductBId(productId);
	}
	
	
	@PutMapping(value="/updateproduct/{productId}")
	public Products updateProduct(@RequestBody Products product, @PathVariable int productId) {
		return productService.updateProducts(product, productId);
	}
	
	
	@DeleteMapping(value = "/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId){
		productService.deleteCProducts(productId);
		
		String m= "Product Id " + productId + " has been delete sucessfully";
		return ResponseEntity.ok(m);
	}
	

}
