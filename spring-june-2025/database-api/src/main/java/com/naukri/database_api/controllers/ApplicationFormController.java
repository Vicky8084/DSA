package com.naukri.database_api.controllers;

import com.naukri.database_api.models.ApplicationForm;
import com.naukri.database_api.repositories.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/applicationForm")
public class ApplicationFormController {

    ApplicationFormRepository applicationFormRepository;
    @Autowired
    public ApplicationFormController(ApplicationFormRepository applicationFormRepository){
        this.applicationFormRepository=applicationFormRepository;
    }
    @PostMapping("/save")
    public ResponseEntity saveApplicationForm(@RequestBody ApplicationForm applicationForm){
        applicationFormRepository.save(applicationForm);
        return new ResponseEntity(applicationForm, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity getApplicationFormById(@PathVariable UUID id){
        ApplicationForm applicationForm=applicationFormRepository.findById(id).orElse(null);
        return new ResponseEntity(applicationForm,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateApplicationForm(@RequestBody ApplicationForm applicationForm){
        applicationFormRepository.save(applicationForm);
        return new ResponseEntity(applicationForm,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteApplicationFormById(@PathVariable UUID id){
        applicationFormRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
