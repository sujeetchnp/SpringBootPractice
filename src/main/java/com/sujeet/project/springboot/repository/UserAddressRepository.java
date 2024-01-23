package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

    List<UserAddress> findAll();

    List<UserAddress> findUserAddressByCity(String city);

}
