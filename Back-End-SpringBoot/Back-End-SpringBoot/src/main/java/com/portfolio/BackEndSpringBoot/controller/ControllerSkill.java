package com.portfolio.BackEndSpringBoot.controller;


import com.portfolio.BackEndSpringBoot.model.Skill;
import com.portfolio.BackEndSpringBoot.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/skills")
public class ControllerSkill {

    @Autowired
    private ISkillService skillService;
//
//    @PostMapping("/add")
//    public void add_skill(@RequestBody Skill skill){
//        skillService.add_skill(skill);
//    }
//
//    @GetMapping("/see")
//    @ResponseBody
//    public List<Skill> get_skills(){
//        return skillService.get_skills();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete_skill(@PathVariable Long id){
//        skillService.delete_skill(id);
//    }
//
//    @PutMapping("/edit")
//    public void edit_skill(@RequestBody Skill skill){
//        //Skill editSkill = skillService.edit_skill(skill);
//        skillService.edit_skill(skill);
//    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills(){
        List<Skill> skill = skillService.get_skills();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> add_skill(@RequestBody Skill skill) {
        Skill newSkill = skillService.add_skill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Skill> edit_skill(@RequestBody Skill skill) {
        Skill editSkill = skillService.edit_skill(skill);
        return new ResponseEntity<>(editSkill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete_skill(@PathVariable("id") Long id) {
        skillService.delete_skill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
