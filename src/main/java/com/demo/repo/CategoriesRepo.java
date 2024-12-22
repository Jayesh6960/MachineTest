package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Categories;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Integer>{
	


}
