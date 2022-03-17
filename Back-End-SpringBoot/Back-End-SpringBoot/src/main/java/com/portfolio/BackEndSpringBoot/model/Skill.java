package com.portfolio.BackEndSpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Skill {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int percentage;

    public Skill(){

    }

    public Skill(Long id, String name, int percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
    }
}
