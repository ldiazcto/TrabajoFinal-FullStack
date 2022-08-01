package com.portfolio.BackEndSpringBoot.controller;


import com.portfolio.BackEndSpringBoot.model.Project;
import com.portfolio.BackEndSpringBoot.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"https://portfolio-lu.web.app"})
@RestController
@RequestMapping("/projects")
public class ControllerProject {

    @Autowired
    private IProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProyectos(){
        List<Project> projects = projectService.get_project();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Project> add_project(@RequestBody Project project) {
        Project newProject = projectService.add_project(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Project> edit_project(@RequestBody Project project) {
        Project editProyecto = projectService.edit_project(project);
        return new ResponseEntity<>(editProyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete_project(@PathVariable("id") Long id) {
        projectService.delete_project(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
