package com.example.springAuth.persistance.repos;

import com.example.springAuth.persistance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepo extends JpaRepository<Product,Long> {
    ArrayList<Product> findAllByProductName(String productName);
}
