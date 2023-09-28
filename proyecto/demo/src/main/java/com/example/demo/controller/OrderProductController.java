package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderProduct;

import com.example.demo.service.OrderProductService;


@RestController
@RequestMapping("/api/v1/orders")

@CrossOrigin(origins = "*")

public class OrderProductController {
	
	
	// inyectamos mi capa de servicio
	@Autowired
	OrderProductService orderService;
	
	
	@PostMapping
	public ResponseEntity<OrderProduct> createOrders(@RequestBody OrderProduct order) {
		OrderProduct newOrder= orderService.createOrder(order);
		return new ResponseEntity<> (newOrder, HttpStatus.CREATED);	
				}
	
	
	@GetMapping("{id}")
	public ResponseEntity< OrderProduct > getOrderById(@PathVariable Long id){
		OrderProduct order = orderService.getOrderById(id);
		return new ResponseEntity<>(order, HttpStatus.OK); // Status 200
	}
	
	@GetMapping
	public ResponseEntity< List<OrderProduct> > getAllOrders(){
		List<OrderProduct> orders = orderService.getAllOrders();
		return new ResponseEntity<>( orders, HttpStatus.OK );
	}
	

}
