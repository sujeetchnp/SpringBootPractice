package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Integer> {

    List<UserAddressEntity> findAll();

    List<UserAddressEntity> findUserAddressByCity(String city);

    @Modifying
    @Query("DELETE FROM UserAddressEntity a WHERE a.id = :idParam")
    int deleteUserByAddressId(@Param("idParam") Integer id);


}
