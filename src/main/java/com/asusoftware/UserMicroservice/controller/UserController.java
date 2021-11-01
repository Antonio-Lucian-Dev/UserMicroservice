package com.asusoftware.UserMicroservice.controller;

import com.asusoftware.UserMicroservice.model.dto.CreateUserDto;
import com.asusoftware.UserMicroservice.model.dto.UserDto;
import com.asusoftware.UserMicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create/{uuid}")
    public void create(@Valid @RequestBody CreateUserDto createUserDto, @PathVariable(name = "uuid") UUID uuid) {
        userService.create(createUserDto, uuid);
    }

    @GetMapping(path = "/findAll")
    public List<UserDto> findAllUsers() {
        return userService.findAll().stream().map(UserDto::toDto).collect(Collectors.toList());
    }

    @GetMapping(path = "/{uuid}")
    public UserDto findUserById(@PathVariable(name = "uuid") UUID uuid) {
        return UserDto.toDto(userService.findById(uuid));
    }

    @DeleteMapping
    public void delete(UUID uuid) {
        userService.delete(uuid);
    }
}
