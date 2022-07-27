package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Project;
import com.portfolio.BackEndSpringBoot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService implements IProjectService{

    @Autowired
    public ProjectRepository projectRepo;

    @Override
    public List<Project> get_project() {
        return projectRepo.findAll();
    }

    @Override
    public Project add_project(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public void delete_project(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Project find_project(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public Project edit_project(Project project) {
        return projectRepo.save(project);
    }
}
