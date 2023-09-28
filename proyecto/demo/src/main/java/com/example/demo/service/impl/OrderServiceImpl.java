package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderProduct;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.service.OrderProductService;




@Service
public class OrderServiceImpl implements OrderProductService{

	@Autowired
	OrderProductRepository  orderRepository;
	
	
	@Override
	public OrderProduct createOrder(OrderProduct order) {
		
	
		return saveOrder(order);
	}

	public OrderProduct saveOrder(OrderProduct order) {
		return orderRepository.save(order);
	}
	
	
	@Override
	public OrderProduct getOrderById(Long id) {
		return orderRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Order doses not exist with id "+ id) );
	
	
	}

	@Override
	public List<OrderProduct> getAllOrders() {
	
		return (List<OrderProduct>) orderRepository.findAll();
	}

	
	@Override
	public OrderProduct updateOrder(OrderProduct order, Long id) {
	    OrderProduct existingOrder= getOrderById(id);
	    existingOrder.setProducts(order.getProducts());
		return saveOrder(existingOrder);
	}

	@Override
	public void deleteOrder(Long id) {
		OrderProduct existingOrder= getOrderById(id);
	    orderRepository.delete(existingOrder);
		
		
	}

}
