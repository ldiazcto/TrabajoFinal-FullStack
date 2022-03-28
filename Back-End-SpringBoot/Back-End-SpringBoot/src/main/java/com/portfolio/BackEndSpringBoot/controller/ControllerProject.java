package com.portfolio.BackEndSpringBoot.controller;


import com.portfolio.BackEndSpringBoot.model.Project;
import com.portfolio.BackEndSpringBoot.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerProject {

    @Autowired
    private IProjectService projectService;

    @PostMapping("/new/project")
    public void add_project(@RequestBody Project project){
        projectService.add_project(project);
    }

    @GetMapping("/see/project")
    @ResponseBody
    public List<Project> get_project(){
        return projectService.get_project();
    }

    @DeleteMapping("/deleteProject/{id}")
    public void delete_project(@PathVariable Long id){
        projectService.delete_project(id);
    }

    @PutMapping("/editProject/{id}")
    public void update_project(@PathVariable Long id, @RequestBody Project project){
        projectService.delete_project(id);
        projectService.add_project(project);
    }


}
