package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;


	   
@Entity
@Table(name = "products")
@Data

public class Product
	   
	    {
	        @Id
	        @GeneratedValue(strategy= GenerationType.IDENTITY)
	        private Long id_product;
	        private String name;
	        private String description;
	        private String img_url;
	        private Double abv;
	        private String origin;
	        private Double price;
	        private Integer size;
	        private Integer stock;

	     /*   public Integer getId()
	todo esto se elimina con los anottation de lombok
	            return id;
	      

	        public void setId( Integer id )
	        {
	            this.id = id;
	        }  

	        
	        public Long getId()
	        {
	            return id_product;
	        }

	        public String getName()
	        {
	            return name;
	        }

	        public void setName( String name )
	        {
	            this.name = name;
	        }

	        public String getDescription()
	        {
	            return description;
	        }

	        public void setDescription( String description )
	        {
	            this.description = description;
	        }

	        public String getImage()
	        {
	            return img_url;
	        }

	       /* public void setImageUrl( String imageUrl )
	        {
	            this.img_url = imageUrl;
	        }*/
	    }
