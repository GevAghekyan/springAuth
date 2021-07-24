package com.example.springAuth.persistance.repos;

import com.example.springAuth.persistance.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
