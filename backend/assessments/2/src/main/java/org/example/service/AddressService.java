package org.example.service;

import org.example.dao.AddressRepository;
import org.example.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository)
    {
        this.addressRepository=addressRepository;
    }
    public void addAddress(Address address)
    {
        addressRepository.save(address);
    }
}
