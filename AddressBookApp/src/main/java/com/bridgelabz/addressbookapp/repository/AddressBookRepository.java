package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData, Long> {
    @Query(value = "select  * from contact_data order by city", nativeQuery = true)
    List<AddressBookData> sortByCity();
    @Query(value = "select * from contact_data order by state", nativeQuery = true)
    List<AddressBookData> sortByState();
}
