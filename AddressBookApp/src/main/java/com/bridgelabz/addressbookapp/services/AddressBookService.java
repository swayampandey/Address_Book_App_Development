package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.util.AddressBookToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    AddressBookToken addressBookToken;

    @Override
    public AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO) {
        AddressBookData contactData = null;
        contactData = new AddressBookData(addressBookDTO);
        addressBookRepository.save(contactData);
        return contactData;
    }

    @Override
    public List<AddressBookData> getAddressBookContactData() {

        return (List<AddressBookData>) addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookContactDataById(Long id) {
        AddressBookData contactData = addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Contact Not Found"));

        return contactData;
    }

    @Override
    public AddressBookData updateAddressBookContactData(Long id, AddressBookDTO addressBookDTO) {
        AddressBookData contactData = addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Id not exist"));
        contactData.updateContactInfo(addressBookDTO);
        return addressBookRepository.save(contactData);
    }

    @Override
    public void deleteAddressBookContactData(Long id) {
        addressBookRepository.deleteById(id);

    }

    @Override
    public List<AddressBookData> sortContactsByCity() {

        return addressBookRepository.sortByCity();
    }

    @Override
    public List<AddressBookData> sortContactsByState() {

        return addressBookRepository.sortByState();
    }
}
