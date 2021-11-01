package com.asusoftware.UserMicroservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column(name = "city")
    private String city;

    @NotBlank
    @Column(name = "country")
    private String country;

    @NotNull
    @Column(name = "zip_code")
    private int zipCode;

}
