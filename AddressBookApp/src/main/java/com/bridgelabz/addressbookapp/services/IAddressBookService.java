package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;


import java.util.List;


public interface IAddressBookService {

    AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO);
    List<AddressBookData> getAddressBookContactData();
    AddressBookData getAddressBookContactDataById(Long id);
    AddressBookData updateAddressBookContactData(Long id,AddressBookDTO addressBookDTO);
    void deleteAddressBookContactData(Long id);
    List<AddressBookData> sortContactsByCity();
    List<AddressBookData> sortContactsByState();
}
