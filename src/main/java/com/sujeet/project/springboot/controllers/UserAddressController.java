package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.model.UserAddress;
import com.sujeet.project.springboot.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-address")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/addresses")
    public List<UserAddress> getAllUserAddress() {
        return userAddressService.getAllUserAddresses();
    }

    @PostMapping("/save")
    public String saveUserAddress(@RequestBody UserAddress userAddress) {
        userAddressService.saveUserAddress(userAddress);
        return "User Address saved successfully. ";
    }

    @DeleteMapping("/delete-address")
    public ResponseEntity<String> deleteUser(@RequestBody UserAddress userAddress) {
        int rowsDeleted = userAddressService.deleteRecord(userAddress);
        if (rowsDeleted > 0) {
            return ResponseEntity.ok("User address deleted successfully. ");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user address found with the given ID. ");
        }
    }
}
