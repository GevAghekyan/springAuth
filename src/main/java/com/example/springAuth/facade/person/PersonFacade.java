package com.example.springAuth.facade.person;

import com.example.springAuth.annotations.Facade;
import com.example.springAuth.controller.person.models.PersonRequestModel;
import com.example.springAuth.controller.person.models.PersonResponseModel;
import com.example.springAuth.converter.PersonConverter;
import com.example.springAuth.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class PersonFacade {

    private final PersonService personService;
    private final PersonConverter personConverter;

    @Autowired
    public PersonFacade(PersonService personService, PersonConverter personConverter) {
        this.personService = personService;
        this.personConverter = personConverter;
    }

    public PersonResponseModel createUser(PersonRequestModel requestModel) {
        PersonDTO personDTO = personConverter.buildDataObjFromRequest(requestModel);
        personDTO.setRoles("ROLE_USER");
        PersonDTO savedDataObject = personService.create(personDTO);
        PersonResponseModel responseModel = personConverter.buildResponseFromDataObj(savedDataObject);
        return responseModel;
    }

    public PersonResponseModel createAdmin(PersonRequestModel requestModel) {
        PersonDTO personDTO = personConverter.buildDataObjFromRequest(requestModel);
        personDTO.setRoles("ROLE_ADMIN");
        PersonDTO savedDataObject = personService.create(personDTO);
        PersonResponseModel responseModel = personConverter.buildResponseFromDataObj(savedDataObject);
        return responseModel;
    }

    public PersonResponseModel getById(Long id) {
        PersonDTO byId = personService.getById(id);
        PersonResponseModel personResponseModel = personConverter.buildResponseFromDataObj(byId);
        return personResponseModel;
    }

    public ArrayList<PersonResponseModel> findAll() {
        ArrayList<PersonDTO> all = personService.findAll();
        List<PersonResponseModel> responseModels = all.stream()
                .map(each -> personConverter.buildResponseFromDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<PersonResponseModel>) responseModels;
    }

    public PersonResponseModel findByName(String name) {
        PersonDTO byName = personService.findByName(name);
        PersonResponseModel personResponseModel = personConverter.buildResponseFromDataObj(byName);
        return personResponseModel;
    }

    public ArrayList<PersonResponseModel> findAllByAge(Integer age) {
        ArrayList<PersonDTO> all = personService.findAllByAge(age);
        List<PersonResponseModel> responseModels = all.stream()
                .map(each -> personConverter.buildResponseFromDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<PersonResponseModel>) responseModels;
    }

    public PersonResponseModel updateById(PersonRequestModel requestModel, Long id) {
        PersonDTO personDTO = personConverter.buildDataObjFromRequest(requestModel);
        personDTO.setId(id);
        PersonDTO updateById = personService.updateById(personDTO);
        PersonResponseModel responseModel = personConverter.buildResponseFromDataObj(updateById);
        return responseModel;
    }

    public void deleteById(Long id) {
        personService.deleteById(id);
    }
}
