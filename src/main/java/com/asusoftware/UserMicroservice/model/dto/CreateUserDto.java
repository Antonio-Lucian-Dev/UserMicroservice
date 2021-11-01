package com.asusoftware.UserMicroservice.model.dto;

import com.asusoftware.UserMicroservice.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateUserDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String profileImage;
    @NotNull
    private Date birthday;
    @NotNull
    private String password;
    @NotNull
    private UserAddressDto userAddressDto;

    public User toEntity(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setProfileImage(createUserDto.getProfileImage());
        user.setBirthday(createUserDto.getBirthday());
        return user;
    }
}
