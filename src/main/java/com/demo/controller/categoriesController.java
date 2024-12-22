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

import com.demo.entities.Categories;
import com.demo.service.CategoriesService;

@RestController
@RequestMapping("/api/categories")
public class categoriesController {
	@Autowired
	private CategoriesService categoriesService;
	
	@PostMapping(value="/")
	public Categories createCategories(@RequestBody Categories categories) {
		return categoriesService.createCategories(categories);
		
	}
	
	@PutMapping(value="{categoryId}")
	public Categories updateCategories(@RequestBody Categories categories, @PathVariable Integer categoryId) {
		return categoriesService.updateCategories(categories, categoryId);
	}
	
	
	@GetMapping(value="{categoryId}")
	public Categories getCategoriesById(@PathVariable Integer categoryId) {
		return categoriesService.getCategoriesById(categoryId);
	}
	
	@GetMapping(value="/getall")
	public List<Categories> getAllCategories(){
		return categoriesService.getCategories();
		}
	
	@DeleteMapping(value="{categoryId}")
	public ResponseEntity<String> deleteCategories(@PathVariable Integer categoryId) {
		categoriesService.deleteCategories(categoryId);
		
		String m= "Category Id " + categoryId + " has been delete sucessfully";
		return ResponseEntity.ok(m);
		
	}
	

}
