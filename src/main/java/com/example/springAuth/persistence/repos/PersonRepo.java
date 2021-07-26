package com.example.springAuth.persistence.repos;

import com.example.springAuth.persistence.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Long> {
    Person findByName(String name);
    ArrayList<Person> findAllByAge(Integer age);
    Optional<Person> findByUserName(String userName);
}
