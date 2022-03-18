package com.portfolio.BackEndSpringBoot.controller;


import com.portfolio.BackEndSpringBoot.model.Skill;
import com.portfolio.BackEndSpringBoot.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerSkill {

    @Autowired
    private ISkillService skillService;

    @PostMapping("/new/skill")
    public void add_skill(@RequestBody Skill skill){
        skillService.add_skill(skill);
    }

    @GetMapping("/see/skill")
    @ResponseBody
    public List<Skill> get_skills(){
        return skillService.get_skills();
    }

    @DeleteMapping("/deleteSkill/{id}")
    public void delete_skill(@PathVariable Long id){
        skillService.delete_skill(id);
    }
}
