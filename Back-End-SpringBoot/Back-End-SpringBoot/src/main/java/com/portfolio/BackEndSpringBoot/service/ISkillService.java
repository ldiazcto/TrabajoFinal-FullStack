package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Skill;

import java.util.List;

public interface ISkillService {

    public List<Skill> see_skill();

    public void create_skill(Skill skill);

    public void delete_skill(Long id);

    public Skill find_skill(Long id);

    public void edit_skill(Long id);
}
