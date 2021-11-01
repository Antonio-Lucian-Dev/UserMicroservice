package com.asusoftware.UserMicroservice.service;

import com.asusoftware.UserMicroservice.model.Address;
import com.asusoftware.UserMicroservice.model.User;
import com.asusoftware.UserMicroservice.model.UserAddress;
import com.asusoftware.UserMicroservice.model.dto.CreateUserDto;
import com.asusoftware.UserMicroservice.repository.AddressRepository;
import com.asusoftware.UserMicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAddressService userAddressService;

    public void create(CreateUserDto createUserDto, UUID uuid) {
        User user = createUserDto.toEntity(createUserDto);
        UserAddress userAddress = userAddressService.create(createUserDto.getUserAddressDto(),uuid);
        userAddress.setUser(user);
        userRepository.save(user);
    }

    public User findById(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
