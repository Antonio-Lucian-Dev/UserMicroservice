package com.asusoftware.UserMicroservice.controller;

import com.asusoftware.UserMicroservice.model.dto.AddressDto;
import com.asusoftware.UserMicroservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping(path = "/findAll")
    public List<AddressDto> findAllUsers() {
        return addressRepository.findAll().stream().map(AddressDto::toDto).collect(Collectors.toList());
    }
}
