package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.UserClient;

public interface UserClientRepository extends CrudRepository<UserClient, Long>  {

}
