package com.portfolio.BackEndSpringBoot.service;


import com.portfolio.BackEndSpringBoot.model.Skill;
import com.portfolio.BackEndSpringBoot.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService{

    @Autowired
    public SkillRepository skillRepo;


    @Override
    public List<Skill> see_skill() {
        return skillRepo.findAll();
    }

    @Override
    public void create_skill(Skill skill) {
         skillRepo.save(skill);
    }

    @Override
    public void delete_skill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill find_skill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void edit_skill(Long id) {

    }
}