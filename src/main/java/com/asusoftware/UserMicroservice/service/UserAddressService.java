package com.asusoftware.UserMicroservice.service;

import com.asusoftware.UserMicroservice.model.Address;
import com.asusoftware.UserMicroservice.model.UserAddress;
import com.asusoftware.UserMicroservice.model.dto.UserAddressDto;
import com.asusoftware.UserMicroservice.repository.AddressRepository;
import com.asusoftware.UserMicroservice.repository.UserAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAddressService {

    private final UserAddressRepository userAddressRepository;
    private final AddressRepository addressRepository;

    public UserAddress create(UserAddressDto userAddressDto, UUID uuid) {
        UserAddress userAddress = new UserAddress();
        userAddress.setStreet(userAddressDto.getStreet());
        userAddress.setStreetNumber(userAddressDto.getStreetNumber());
        Address address = addressRepository.findById(uuid).orElse(null);
        userAddress.setAddress(address);
        userAddressRepository.save(userAddress);
        return userAddress;
    }

    public List<UserAddress> findAll() {
        return userAddressRepository.findAll();
    }
}
