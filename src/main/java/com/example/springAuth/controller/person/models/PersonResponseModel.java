package com.example.springAuth.controller.person.models;

import com.example.springAuth.controller.address.models.AddressResponseModel;

public class PersonResponseModel {

    private Long id;
    private String name;
    private Integer age;
    private AddressResponseModel addressResponseModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressResponseModel getAddressResponseModel() {
        return addressResponseModel;
    }

    public void setAddressResponseModel(AddressResponseModel addressResponseModel) {
        this.addressResponseModel = addressResponseModel;
    }
}
