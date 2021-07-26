package com.example.springAuth.persistence.repos;

import com.example.springAuth.persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
