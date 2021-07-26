package com.example.springAuth.persistence.repos;

import com.example.springAuth.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepo extends JpaRepository<Product,Long> {
    ArrayList<Product> findAllByProductName(String productName);
}
