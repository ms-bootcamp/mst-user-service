package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.Repository.AddressRepository;
import com.thoughtworks.mstorderservice.entity.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> findByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }
}
