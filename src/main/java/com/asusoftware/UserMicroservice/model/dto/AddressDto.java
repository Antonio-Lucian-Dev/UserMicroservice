package com.asusoftware.UserMicroservice.model.dto;

import com.asusoftware.UserMicroservice.model.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class AddressDto {

    private UUID id;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    @NotNull
    private int zipCode;
    @Nullable
    private String street;
    @Nullable
    private int streetNumber;

    public static Address toEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        return address;
    }

    public static AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }

}
