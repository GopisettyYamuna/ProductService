package com.productservice.jpa.r;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.jpa.entity.ProductService;
@Repository
public interface ProductServicetRepository extends JpaRepository<ProductService,Long>{


		
	}

	

	
	

