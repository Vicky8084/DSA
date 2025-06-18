package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Questions;
import com.naukri.database_api.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/Question")
public class QuestionController {
    QuestionsRepository questionsRepository;
    @Autowired
    public QuestionController(QuestionsRepository questionsRepository){
        this.questionsRepository=questionsRepository;
    }
    @PostMapping("/save")
    public ResponseEntity saveQuestion(@RequestBody Questions questions){
        questionsRepository.save(questions);
        return new ResponseEntity(questions, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity getQuestion(@PathVariable UUID id){
        Questions questions=questionsRepository.findById(id).orElse(null);
        return new ResponseEntity(questions,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateQuestion(@RequestBody Questions questions){
        questionsRepository.save(questions);
        return new ResponseEntity(questions, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuestion(@PathVariable UUID id){
        questionsRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
