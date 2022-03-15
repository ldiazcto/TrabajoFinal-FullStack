package com.portfolio.BackEndSpringBoot.model;

public class Person {

    private Long id;
    private String name;
    private String last_name;
    private Long phone;
    private String email;
    private String about_me;
    private String adress;

    public Person() {
    }

    public Person(Long id, String name, String last_name, Long phone, String email, String about_me, String adress) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.about_me = about_me;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
