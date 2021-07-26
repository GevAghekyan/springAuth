package com.example.springAuth.persistence.repos;

import com.example.springAuth.persistence.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
