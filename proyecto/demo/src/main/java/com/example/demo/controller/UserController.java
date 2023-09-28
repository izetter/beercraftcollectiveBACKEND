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

import com.example.demo.entity.UserClient;
import com.example.demo.service.UserClientService;



@CrossOrigin(origins = "*")
@RestController // @Controller @ResponseBody
@RequestMapping("api/v1/users") // localhost:8080/api/vi/user
public class UserController {



		@Autowired
		UserClientService userService;
		
		@GetMapping // localhost:8080/api/v1/users
		public ResponseEntity<List<UserClient>> getAllUsers(){
			List<UserClient> users = userService.getAllUsers();
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		
		@GetMapping("{id}") // localhost:8080/api/v1/users/2
		public ResponseEntity<UserClient> getUserById(@PathVariable long id) {
			UserClient user = userService.getUserById(id);
			return new ResponseEntity<>(user , HttpStatus.OK);
		}
		
		@PostMapping  // localhost:8080/api/v1/customers
		public ResponseEntity<UserClient> newUser(@RequestBody UserClient user) {
			
				return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
		}
		
		
		
		
		@PutMapping("{id}")  // localhost:8080/api/vi/customers/2
		public ResponseEntity<UserClient> updateUser(@RequestBody UserClient user, @PathVariable long id) {
			UserClient existingCustomer = userService.updateUser(user, id);
			return new ResponseEntity<>(existingCustomer,HttpStatus.OK);
			
		}
		
		@DeleteMapping("{id}") // localhost:8080/api/v1/customers/2
		public String deleteCustomer(@PathVariable Long id) {
			
			userService.deleteUser(id);
			return "Cliente Eliminado";
			
			/*
			Optional<Customer> optionalCustomer = customerRepository.findById(id); // Objeto de la clase Optional
			
			
			if ( optionalCustomer.isPresent() ) {
			    Customer existingCustomer = optionalCustomer.get();
			    customerRepository.delete(existingCustomer);
			    return "Cliente eliminado";
			}
				
			throw new IllegalStateException("User does not exist");
			*/
		}
		
		
		
		
	}
