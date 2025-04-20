package com.bridgelabz.addressbook.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

import java.util.List;

public @ToString class AddressDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid Name")
    public String name;

    @NotBlank(message = "City cannot be empty")
    public String city;

    @NotBlank(message = "State cannot be empty")
    public String state;

    @NotBlank(message = "Pincode cannot be empty")
    public String pincode;

    @NotNull(message = "Phone number required")
    public List<String> phoneNumber;

    @NotNull(message = "Email required")
    public List<String> email;

}
