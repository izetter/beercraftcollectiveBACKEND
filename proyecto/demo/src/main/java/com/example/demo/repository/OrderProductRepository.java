package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long>{

}
