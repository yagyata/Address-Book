package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.DTO.AddressDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    private String city;
    private String state;
    private String pincode;

    @ElementCollection
    @CollectionTable(name = "phone_numbers", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "phoneNumber")
    private List<String> phoneNumber;

    @ElementCollection
    @CollectionTable(name = "email_addresses",joinColumns = @JoinColumn(name = "id"))
    @Column(name="email")
    private List<String> email;

    public AddressBookData() {}

    public AddressBookData(AddressDTO addressDTO) {
        this.updateAddressBook(addressDTO);
    }

    public void updateAddressBook(AddressDTO addressDTO) {
        this.name = addressDTO.name;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.pincode = addressDTO.pincode;
        this.phoneNumber = addressDTO.phoneNumber;
        this.email = addressDTO.email;
    }


}
