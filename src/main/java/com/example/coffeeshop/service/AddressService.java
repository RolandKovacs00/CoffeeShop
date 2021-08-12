package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Address;
import com.example.coffeeshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> addresses() {
        return addressRepository.findAll();
    }

    public Address addNewProduct(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> findProduct(Long id) {
        return addressRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        addressRepository.deleteById(id);
    }
}

