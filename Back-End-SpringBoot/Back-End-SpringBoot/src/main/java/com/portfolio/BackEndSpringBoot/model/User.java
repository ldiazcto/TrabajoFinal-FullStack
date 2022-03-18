package com.portfolio.BackEndSpringBoot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String last_name;
    private Long phone;
    private String email;
    private String about_me;
    private String adress;

    public User() {
    }

    public User(Long id, String name, String last_name, Long phone, String email, String about_me, String adress) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.about_me = about_me;
        this.adress = adress;
    }

}
