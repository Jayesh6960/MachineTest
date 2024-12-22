package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Categories;
import com.demo.exception.ResourseNotFoundException;
import com.demo.repo.CategoriesRepo;
import com.demo.service.CategoriesService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class categoriesServiceImpl implements CategoriesService{
	
	@Autowired
	private CategoriesRepo categoriesRepo;
	
	

	@Override
	public Categories createCategories(Categories category) {
		
		return categoriesRepo.save(category);
	}

	@Override
	public Categories updateCategories(Categories category, Integer categoryId) {
		Categories exitcategory = categoriesRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category", "categoryId", categoryId));
		exitcategory.setCategoryName(category.getCategoryName());
		exitcategory.setCategoryDescription(category.getCategoryDescription());
		return categoriesRepo.save(exitcategory);
	}

	@Override
	public Categories getCategoriesById(Integer categoryId) {
		
		return categoriesRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category", "categoryId", categoryId));
	}

	
	  @Override public List<Categories> getCategories() {
	  
	  return categoriesRepo.findAll(); }
	 
	


	@Override
	public void deleteCategories(Integer categoryId) {
		Categories categories= categoriesRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category", "categoryId", categoryId));
		categoriesRepo.delete(categories);
	}
	
	

}
