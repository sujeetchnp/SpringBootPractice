package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.model.FlightUser;
import com.sujeet.project.springboot.service.FlightUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class FlightUserController {

    @Autowired
    private FlightUserService flightUserService;

    @GetMapping("/userid")
    public FlightUser getUserById(@RequestParam("id") Integer id) {
        return flightUserService.getAddressByUserId(id);
    }

    @GetMapping("/response/userid")
    public ResponseEntity<FlightUser> getResponseById(@RequestParam("id") Integer id) {
        FlightUser fu = flightUserService.getAddressByUserId(id);
        ResponseEntity<FlightUser> res = ResponseEntity.status(HttpStatus.OK).header("My custome header", "sujeet").body(fu);
        return res;
    }

    @GetMapping("/all-flight-users")
    public List<FlightUser> getListOfAllFlightUsers() {
        return flightUserService.getAllFlightUsers();
    }

    @PutMapping("/update-flight-user")
    public ResponseEntity<String> updateFlightUser(@RequestBody FlightUser flightUser) {
        int rowsUpdated = flightUserService.updateUserOperation(flightUser);
        if (rowsUpdated > 0) {
            return ResponseEntity.ok("User updated successfully. ");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with the given ID. ");
        }
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody FlightUser flightUser) {
        flightUserService.saveFlightUser(flightUser);
        return "Flight User saved successfully";
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFlightUser(@RequestBody FlightUser flightUser) {
        int rowsDeleted = flightUserService.deleteFlightUser(flightUser);
        if (rowsDeleted > 0) {
            return ResponseEntity.ok("Flight User deleted successfully. ");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with the given ID. ");
        }
    }
}
