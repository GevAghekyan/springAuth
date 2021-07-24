package com.example.springAuth.controller.person;

import com.example.springAuth.controller.person.models.PersonRequestModel;
import com.example.springAuth.controller.person.models.PersonResponseModel;
import com.example.springAuth.facade.person.PersonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PersonController {

    private final PersonFacade personFacade;

    @Autowired
    public PersonController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<PersonResponseModel> createUser(@RequestBody PersonRequestModel requestModel) {
        PersonResponseModel saved = personFacade.createUser(requestModel);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<PersonResponseModel> createAdmin(@RequestBody PersonRequestModel requestModel) {
        PersonResponseModel saved = personFacade.createAdmin(requestModel);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonResponseModel> getById(@PathVariable Long id) {
        PersonResponseModel personById = personFacade.getById(id);
        return ResponseEntity.ok(personById);
    }

    @GetMapping("/persons")
    public ResponseEntity<ArrayList<PersonResponseModel>> getAll() {
        System.out.println("persons controller");
        ArrayList<PersonResponseModel> responseModels = personFacade.findAll();
        return ResponseEntity.ok(responseModels);
    }

    @GetMapping("/persons/age/{age}")
    public ResponseEntity<ArrayList<PersonResponseModel>> getAllByAge(@PathVariable Integer age) {
        ArrayList<PersonResponseModel> responseModels = personFacade.findAllByAge(age);
        return ResponseEntity.ok(responseModels);
    }

    @GetMapping("/person/name/{name}")
    public ResponseEntity<PersonResponseModel> getByName(@PathVariable String name) {
        PersonResponseModel personByName = personFacade.findByName(name);
        return ResponseEntity.ok(personByName);
    }

    @PutMapping("/person/update/{id}")
    public ResponseEntity<PersonResponseModel> updateById(@RequestBody PersonRequestModel requestModel,@PathVariable Long id){
        PersonResponseModel responseModel = personFacade.updateById(requestModel, id);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping("/person/delete/{id}")
    public void deleteById(@PathVariable Long id){
        personFacade.deleteById(id);
    }
}
