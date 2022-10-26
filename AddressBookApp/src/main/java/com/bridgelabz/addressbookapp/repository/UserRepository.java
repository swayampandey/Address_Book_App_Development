package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    @Query(value = " select * from user_data where user_name = :userName and password = :password",nativeQuery = true)
    Optional<UserData> checkLogin(String userName, String password);
}
