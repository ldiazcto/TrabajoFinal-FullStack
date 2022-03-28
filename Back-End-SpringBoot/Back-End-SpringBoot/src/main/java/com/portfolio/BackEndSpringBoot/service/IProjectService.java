package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Project;

import java.util.List;

public interface IProjectService {


    public List<Project> get_project();

    public void add_project(Project project);

    public void delete_project(Long id);

    public Project find_project(Long id);

    public void edit_project(Long id);
}
