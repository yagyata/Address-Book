package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    private List<AddressBookData> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBook() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookById(int id) {
        return addressBookRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Id: " + id + "does not exist."));
    }

    @Override
    public AddressBookData createAddressBook(AddressDTO addressDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressDTO);
        log.debug("Address Book Data: " + addressBookData.toString());
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBook(int id, AddressDTO addressDTO) {
        AddressBookData addressBookData =  this.getAddressBookById(id);
        addressBookData.updateAddressBook(addressDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int id) {
        AddressBookData addressBookData = this.getAddressBookById(id);
        addressBookRepository.delete(addressBookData);
    }

}
