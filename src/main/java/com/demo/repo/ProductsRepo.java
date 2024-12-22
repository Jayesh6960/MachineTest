package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Products;


@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{
	
	List<Products> findByCategory_CategoryId(int categoryId);

}
