package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;


@RestController
@RequestMapping("/api")
public class ProductController {
 
	@Autowired
	     ProductRepository productRepository;


	 /*   public ItemController(@Autowired ItemRepository itemRepository )
	    {
	        this.itemRepository = itemRepository;
	    */

	    @GetMapping
	    public List<Product> getProducts(){
	    	List <Product> products= (List<Product>)productRepository.findAll();
	        return products;
}
	    
	    @GetMapping("{id}")
		public Product getProductById(@PathVariable long id) {
			Product product = productRepository.findById(id);
			
			return product;	
		}
	    
	    
}


