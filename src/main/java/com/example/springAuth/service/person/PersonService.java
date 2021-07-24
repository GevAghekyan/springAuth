package com.example.springAuth.service.person;

import com.example.springAuth.facade.person.PersonDTO;

import java.util.ArrayList;

public interface PersonService {

    PersonDTO create(PersonDTO dto);

    PersonDTO getById(Long id);

    ArrayList<PersonDTO> findAll();

    PersonDTO findByName(String name);

    ArrayList<PersonDTO> findAllByAge(Integer age);

    PersonDTO updateById(PersonDTO dto);

    void deleteById(Long id);

}
