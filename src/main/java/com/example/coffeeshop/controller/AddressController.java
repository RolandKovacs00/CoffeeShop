package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Address;
import com.example.coffeeshop.repository.AddressRepository;
import com.example.coffeeshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    private final AddressRepository addressRepository;
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressRepository addressRepository, AddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @GetMapping("/allAdresses")
    public ResponseEntity<List<Address>> address() {
        List<Address> addresses = addressService.addresses();
        return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
    }

    @PostMapping("/newAddress")
    public ResponseEntity<Address> addNewProduct(@RequestBody Address addr) {
        Address address = null;
        try {
            address = addressService.addNewProduct(addr);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @DeleteMapping("deleteAddress/{id}")
    public void delete(@PathVariable Long id) {
        addressService.deleteProduct(id);
    }

    @PutMapping("updateAddress/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address addresses) {
        Optional<Address> addr = addressRepository.findById(id);
        if (addr.isPresent()) {
            Address address = addr.get();
            address.setStreet(addresses.getStreet());
            address.setNr(addresses.getNr());
            address.setLocality(addresses.getLocality());
            address.setCity(addresses.getCity());
            return new ResponseEntity<>(addressService.addNewProduct(address), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("address/{id}")
    public Optional<Address> getProductById(@PathVariable Long id) {
        return addressService.findProduct(id);
    }
}
