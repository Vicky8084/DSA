package com.naukri.database_api.controllers;

import com.naukri.database_api.models.FormSubmission;
import com.naukri.database_api.repositories.FormSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/formSubmission")
public class FormSubmissionController {
    FormSubmissionRepository formSubmissionRepository;
    @Autowired
    public FormSubmissionController(FormSubmissionRepository formSubmissionRepository){
        this.formSubmissionRepository=formSubmissionRepository;
    }
    @PostMapping("/save")
    public ResponseEntity saveFormSubmission(@RequestBody FormSubmission formSubmission){
        formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmission, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getFormSubmissionById(@PathVariable UUID id){
        FormSubmission formSubmission=formSubmissionRepository.findById(id).orElse(null);
        return new ResponseEntity(formSubmission,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateFormSubmission(@RequestBody FormSubmission formSubmission){
        formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmission, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFormSubmission(@PathVariable UUID id){
        formSubmissionRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
