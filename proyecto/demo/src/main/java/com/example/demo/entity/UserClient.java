package com.example.demo.entity;




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
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class UserClient {
	
	
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_user;
	
    @Column(nullable=false, length= 150)
    private String name;
    
    @Column(nullable=false, length= 15)
    private String phone;
    
    @Column(nullable=false,length=200, unique=true)
    private String email;
    
    @Column(nullable=false, length= 200)
    private String password;
    
    @Column(insertable=false, updatable=false,
    		columnDefinition= "integer default 1")
    private Integer  id_rol;
    
    
    
   
}


