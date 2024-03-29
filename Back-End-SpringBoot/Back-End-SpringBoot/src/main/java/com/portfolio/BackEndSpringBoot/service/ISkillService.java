package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Skill;

import java.util.List;

public interface ISkillService {

    public List<Skill> get_skills();

    public Skill add_skill(Skill skill);

    public void delete_skill(Long id);

    public Skill find_skill(Long id);

    public Skill edit_skill(Skill skill);
}
