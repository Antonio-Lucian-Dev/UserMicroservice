package com.asusoftware.UserMicroservice.model.dto;

import com.asusoftware.UserMicroservice.model.UserAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserAddressDto {
    @Nullable
    private String street;
    @Nullable
    private int streetNumber;
    @NotNull
    private UserDto userDto;
    private AddressDto addressDto;

    public static UserAddressDto toDto(UserAddress userAddress) {
        UserAddressDto userAddressDto = new UserAddressDto();
        userAddressDto.setStreet(userAddress.getStreet());
        userAddressDto.setStreetNumber(userAddress.getStreetNumber());
        userAddressDto.setUserDto(UserDto.toDto(userAddress.getUser()));
        userAddressDto.setAddressDto(AddressDto.toDto(userAddress.getAddress()));
        return userAddressDto;
    }
}
