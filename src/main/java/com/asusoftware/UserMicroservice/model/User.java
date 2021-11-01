package com.asusoftware.UserMicroservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column(name = "first_name")
    @Min(value = 5, message = "Insert minimum of 5 character")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    @Min(value = 5, message = "Insert minimum of 5 character")
    private String lastName;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "profile_image")
    private String profileImage;

    @NotNull
    @Column(name = "birthday")
    private Date birthday;

    @NotBlank
    @Column(name = "password")
    @Min(value = 5, message = "Insert minimum of 5 character")
    private String password;

    @OneToMany(mappedBy="user")
    private List<UserAddress> userAddressList;
}
