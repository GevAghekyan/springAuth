package com.example.springAuth.persistance.repos;

import com.example.springAuth.persistance.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
