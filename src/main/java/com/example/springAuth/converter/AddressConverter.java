package com.example.springAuth.converter;

import com.example.springAuth.annotations.Converter;
import com.example.springAuth.controller.address.models.AddressRequestModel;
import com.example.springAuth.controller.address.models.AddressResponseModel;
import com.example.springAuth.facade.address.AddressDTO;

@Converter
public class AddressConverter {

    public AddressDTO addressDataObjFromRequest(AddressRequestModel requestModel) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(requestModel.getCity());
        addressDTO.setStreet(requestModel.getStreet());
        return addressDTO;
    }

    public AddressResponseModel responseFromAddressDataObj(AddressDTO dto) {
        AddressResponseModel responseModel = new AddressResponseModel();
        responseModel.setId(dto.getId());
        responseModel.setCity(dto.getCity());
        responseModel.setStreet(dto.getStreet());
        return responseModel;
    }
}
