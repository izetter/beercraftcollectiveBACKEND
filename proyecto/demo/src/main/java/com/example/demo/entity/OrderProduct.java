package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "order_products")

public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserClient user; // Relación Many-to-One con UserClient

    @ManyToMany
    @JoinTable(
        name = "order_product_product",
        joinColumns = @JoinColumn(name = "order_product_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products; // Relación Many-to-Many con Product

    private Double amount;

    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp purchaseDate;

   // Getters y setters
    // ...
}

	 
