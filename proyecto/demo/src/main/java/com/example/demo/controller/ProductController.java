package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;

import com.example.demo.service.ProductService;



@RestController
@RequestMapping("/api/v1/products")

@CrossOrigin(origins = "*")
public class ProductController {
 
		@Autowired
	     ProductService productService; 
		
		@GetMapping
		public ResponseEntity<List<Product>> getProducts(){
			List<Product> products = (List<Product> )productService.getAllProducts();
			return new ResponseEntity<>( products, HttpStatus.OK );
		}
	    
	   	    
	    @GetMapping("{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable long id) {
			return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);	
		}
	    
	    @PostMapping
	    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
			return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
		}
		
		@PutMapping("{id}")  
			public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id ) {
				return new ResponseEntity<>(productService.updateProduct(product, id),HttpStatus.OK);
				
			}
		

		@DeleteMapping("{id}") // localhost:8080/api/v1/products/

		
		
		public void deleteProduct(@PathVariable long id) {
			productService.deleteProduct(id);
		}
		
}
		
		/*
		 * 
		 * 
		 * peticion sobre la arquitectura de solicitud directa al Repository
		 * public String deleteProduct(@PathVariable Long id) {
		
			Optional<Product> optionalProduct = productRepository.findById(id); // Objeto de la clase Optional
			
			if ( optionalProduct.isPresent() ) {
			   Product existingProduct = optionalProduct.get();
			    productRepository.delete(existingProduct);
			    return "Se elimino el producto";
			}
				
			throw new IllegalStateException("product does not exist");
		 */
			
		
	


	


