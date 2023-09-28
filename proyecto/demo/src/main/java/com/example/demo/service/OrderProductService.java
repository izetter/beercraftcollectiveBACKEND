package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderProduct;

public interface OrderProductService {
	
	
	OrderProduct  createOrder(OrderProduct order);

	OrderProduct  getOrderById( Long id);
	
	List<OrderProduct> getAllOrders();
	
	OrderProduct updateOrder(OrderProduct order, Long id);
	 
	void deleteOrder(Long id);
}
