package com.asusoftware.UserMicroservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_addresses")
@Getter
@Setter
public class UserAddress {

    @Id
    @GeneratedValue
    private UUID id;

    @Nullable
    @Column(name = "street")
    private String street;

    @Nullable
    @Column(name = "city")
    private int streetNumber;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
