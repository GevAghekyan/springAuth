package com.example.springAuth.service.address;

import com.example.springAuth.facade.address.AddressDTO;

import java.util.ArrayList;

public interface AddressService {

    AddressDTO getById(Long id);

    ArrayList<AddressDTO> getAll();

}
