package com.example.springAuth.service.address;

import com.example.springAuth.facade.address.AddressDTO;
import com.example.springAuth.persistence.entities.Address;
import com.example.springAuth.persistence.repos.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public AddressDTO getById(Long id) {
        Address byId = addressRepo.getById(id);
        return dtoFromAddress(byId);
    }

    @Override
    public ArrayList<AddressDTO> getAll() {
        List<Address> all = addressRepo.findAll();
        List<AddressDTO> dataObjects = all.stream()
                .map(each -> dtoFromAddress(each))
                .collect(Collectors.toList());
        return (ArrayList<AddressDTO>) dataObjects;
    }

    private Address addressFromDTO(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        return address;
    }

    private AddressDTO dtoFromAddress(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        return addressDTO;
    }
}
