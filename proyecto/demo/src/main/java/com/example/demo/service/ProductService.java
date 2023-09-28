package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	

		

			Product createProduct(Product product);
			
			Product saveProduct(Product product);
			
			Product getProductById(Long id);
			
			List<Product> getAllProducts();
			
			Product updateProduct(Product product , Long id);
			
			void deleteProduct(Long id);
		}



