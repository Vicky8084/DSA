package com.naukri.database_api.controllers;

import com.naukri.database_api.models.AppUser;
import com.naukri.database_api.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUSerController {
    AppUserRepository appUserRepository;
    @Autowired
    public AppUSerController(AppUserRepository appUserRepository){
        this.appUserRepository=appUserRepository;
    }
    @PostMapping("/save")
    public ResponseEntity createUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return new ResponseEntity(user, HttpStatus.CREATED); //created code status is 201
    }
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable UUID id){
        AppUser user= appUserRepository.findById(id).orElse(null);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable UUID id){
        appUserRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
