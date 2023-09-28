package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



	   
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
	   
	    {
	        @Id
	        @GeneratedValue(strategy= GenerationType.IDENTITY)
	        private Long id;
	        @Column(nullable=false, length= 100)
	        private String name;
	        @Column(nullable=false, length= 150)
	        private String style;
	        private String img;
	        
	        @Column(name = "ABV")
	        private Double ABV;
	        @Column(nullable=false, length= 100)
	        private String origin;
	        private Double price;
	        private Integer size;
	        private Integer stock; 
	        @Column(name= "created_at",insertable=false,
	        		updatable=false,
	        		columnDefinition= "timestamp default CURRENT_TIMESTAMP")
	      private Timestamp createdAt;
	    }


