package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Answer;
import com.naukri.database_api.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/answer")
public class AnswerController {
    AnswerRepository answerRepository;
    @Autowired
    public AnswerController(AnswerRepository answerRepository){
        this.answerRepository=answerRepository;
    }
    @PostMapping("/save")
    public ResponseEntity saveAnswer(@RequestBody Answer answer){
        answerRepository.save(answer);
        return new ResponseEntity(answer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}}")
    public ResponseEntity getAnswerById(@PathVariable UUID id){
        Answer answer=answerRepository.findById(id).orElse(null);
        return new ResponseEntity(answer,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateAnswer(@RequestBody Answer answer){
        answerRepository.save(answer);
        return new ResponseEntity(answer,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAnswer(@PathVariable UUID id){
        answerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
