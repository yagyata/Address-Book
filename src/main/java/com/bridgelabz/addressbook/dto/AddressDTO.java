package com.bridgelabz.addressbook.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @Valid
    public List<@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid phone number") String> phoneNumber;

    @NotEmpty(message = "Email required")
    @Valid
    public List<@Email(message = "Invalid email address") String> email;

}
