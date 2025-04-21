package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBook();
    AddressBookData getAddressBookById(int id);
    AddressBookData createAddressBook(AddressDTO addressDTO);
    AddressBookData updateAddressBook(int id, AddressDTO addressDTO);
    void deleteAddressBookData(int id);


}
