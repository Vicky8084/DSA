package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Skill;
import com.naukri.database_api.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/skill")
public class SkillController {
    SkillsRepository skillsRepository;
    @Autowired
    public SkillController(SkillsRepository skillsRepository){
        this.skillsRepository=skillsRepository;
    }
    @PutMapping("/save")
    public ResponseEntity saveSkill(@RequestBody Skill skill){
        skillsRepository.save(skill);
        return new ResponseEntity(skill, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity getSkill(@PathVariable UUID id){
        Skill skill=skillsRepository.findById(id).orElse(null);
        return new ResponseEntity(skill,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateSkill(@RequestBody Skill skill){
        skillsRepository.save(skill);
        return new ResponseEntity(skill, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSkill(@PathVariable UUID id){
        skillsRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
