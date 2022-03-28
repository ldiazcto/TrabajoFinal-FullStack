package com.portfolio.BackEndSpringBoot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String url_project;
    private String url_image;
    private Long user_id;

    public Project() {
    }

    public Project(Long id, String name, String description, String url_project, String url_image, Long user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url_project = url_project;
        this.url_image = url_image;
        this.user_id = user_id;
    }
}
