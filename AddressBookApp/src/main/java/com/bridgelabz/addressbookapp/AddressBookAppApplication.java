package com.bridgelabz.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookAppApplication {

    public static void main(String[] args) {
        System.out.println("Address Book App is connected");
        SpringApplication.run(AddressBookAppApplication.class, args);
    }

}
