package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
	
			
			return saveProduct(product);
		}



	@Override
	public Product saveProduct(Product product) {
	
			return productRepository.save(product);
	}

	
	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Product does not exist with id "+ id) );
	
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
		
		
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		Product existingProduct= getProductById(id);
		existingProduct.setName( product.getName() );
		existingProduct.setStyle( product.getStyle());
		existingProduct.setImg( product.getImg());
		existingProduct.setABV( product.getABV());
		existingProduct.setOrigin( product.getOrigin());
		existingProduct.setPrice( product.getPrice());
		existingProduct.setSize( product.getSize());
		existingProduct.setStock( product.getStock());
	
	
		return saveProduct(existingProduct);

	}

	@Override
	public void deleteProduct(Long id) {
	
		Product existingProduct = productRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Product does not exist with id "+ id) );
		productRepository.delete(existingProduct);
	}

}
