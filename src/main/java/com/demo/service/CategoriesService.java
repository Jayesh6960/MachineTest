package com.demo.service;

import java.util.List;

import com.demo.entities.Categories;


public interface CategoriesService {
	
	Categories createCategories(Categories category);
	Categories updateCategories(Categories category, Integer categoryId);
	Categories getCategoriesById(Integer categoryId);
	List<Categories> getCategories();
   
	void deleteCategories(Integer categoryId);

}
