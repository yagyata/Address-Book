package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.DTO.AddressDTO;
import com.bridgelabz.addressbook.DTO.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.service.IAddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"","/"})
    public ResponseEntity<ResponseDTO> getAddressBook() {
//        List<AddressBookData> addressBookList = null;
        List<AddressBookData> addressBookList = addressBookService.getAddressBook();
        ResponseDTO respDTO = new ResponseDTO("Get call Successful", addressBookList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable("id") int id) {
//        AddressBookData addressBookData = null;
        AddressBookData addressBookData = addressBookService.getAddressBookById(id);
        ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressDTO addressDTO) {
//        AddressBookData addressBookData = null;
        AddressBookData addressBookData = addressBookService.createAddressBook(addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Added address book data successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable("id") int id,
                                                         @RequestBody AddressDTO addressDTO) {
        AddressBookData addressBookData = addressBookService.updateAddressBook(id, addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated data successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id) {
        addressBookService.deleteAddressBookData(id);
        ResponseDTO respDTO = new ResponseDTO("Deleted data Successfully", "Deleted Id: " + id);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
