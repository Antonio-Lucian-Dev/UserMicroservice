package com.asusoftware.UserMicroservice.model.dto;

import com.asusoftware.UserMicroservice.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDto {

    private UUID id;
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
    private List<UserAddressDto> userAddressDtoList;

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setProfileImage(user.getProfileImage());
        userDto.setBirthday(user.getBirthday());
        userDto.setUserAddressDtoList(user.getUserAddressList().stream().map(UserAddressDto::toDto).collect(Collectors.toList()));
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setProfileImage(userDto.getProfileImage());
        user.setBirthday(userDto.getBirthday());
        return user;
    }
}
