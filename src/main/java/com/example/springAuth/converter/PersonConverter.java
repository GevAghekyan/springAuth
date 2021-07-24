package com.example.springAuth.converter;

import com.example.springAuth.annotations.Converter;
import com.example.springAuth.controller.address.models.AddressResponseModel;
import com.example.springAuth.controller.person.models.PersonRequestModel;
import com.example.springAuth.controller.person.models.PersonResponseModel;
import com.example.springAuth.facade.person.PersonDTO;

@Converter
public class PersonConverter {

    private final AddressConverter addressConverter;

    public PersonConverter(AddressConverter addressConverter) {
        this.addressConverter = addressConverter;
    }

    public PersonDTO buildDataObjFromRequest(PersonRequestModel requestModel) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(requestModel.getName());
        personDTO.setAge(requestModel.getAge());
        personDTO.setCity(requestModel.getCity());
        personDTO.setStreet(requestModel.getStreet());
        personDTO.setUserName(requestModel.getUserName());
        personDTO.setPassword(requestModel.getPassword());
        personDTO.setActive(true);
        return personDTO;
    }

    public PersonResponseModel buildResponseFromDataObj(PersonDTO dataObject) {
        PersonResponseModel personResponseModel = new PersonResponseModel();
        personResponseModel.setName(dataObject.getName());
        personResponseModel.setAge(dataObject.getAge());
        personResponseModel.setId(dataObject.getId());
        personResponseModel.setRoles(dataObject.getRoles());
        AddressResponseModel addressResponseModel = new AddressResponseModel();
        addressResponseModel.setId(dataObject.getAddressId());
        addressResponseModel.setStreet(dataObject.getStreet());
        addressResponseModel.setCity(dataObject.getCity());
        personResponseModel.setAddressResponseModel(addressResponseModel);
        return personResponseModel;
    }
}
