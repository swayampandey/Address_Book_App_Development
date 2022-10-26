package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.services.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAddressBookContactData() {
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", addressBookService.getAddressBookContactData());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookContactData(@PathVariable("id") Long id) {
        ResponseDTO responseDTO = new ResponseDTO("Get call successful for id " + id, addressBookService.getAddressBookContactDataById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> saveDataIntoDataBase(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData contactData = null;
        contactData = addressBookService.createAddressBookContactData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact data created successfully", contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateDataOfDataBase(@PathVariable("id") Long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData contactData = null;
        contactData = addressBookService.updateAddressBookContactData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated the contact information for this id", contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContactById(@PathVariable("id") Long id) {
        addressBookService.deleteAddressBookContactData(id);
    }

    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> sortByCity() {
        List<AddressBookData> contactList = null;
        contactList = addressBookService.sortContactsByCity();
        ResponseDTO responseDTO = new ResponseDTO("Sorted contact details are ", contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> sortByState() {
        List<AddressBookData> contactList = null;
        contactList = addressBookService.sortContactsByState();
        ResponseDTO responseDTO = new ResponseDTO("Sorted contact details are", contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

