package com.portfolio.BackEndSpringBoot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String last_name;
    private String ocuppation;
    private Long phone;
    private String email;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column (columnDefinition = "text")
    private String about_me;
    private String adress;
    private String url_image;
    private String url_cv;

    public Person() {
    }

    public Person(Long id, String name, String last_name, String ocuppation, Long phone, String email, String about_me, String adress, String url_image, String url_cv) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.ocuppation = ocuppation;
        this.phone = phone;
        this.email = email;
        this.about_me = about_me;
        this.adress = adress;
        this.url_image = url_image;
        this.url_cv = url_cv;
    }
}
