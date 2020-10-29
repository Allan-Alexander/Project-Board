package com.projectboard.io.projectboard.service;

import com.projectboard.io.projectboard.Domain.ProjectTask;
import com.projectboard.io.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdate(ProjectTask projectTask){

        if(projectTask.getStatus()==null || projectTask.getStatus()==" "){
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask findById(Long id){
        if(projectTaskRepository.findById(id).isPresent())
            return projectTaskRepository.getById(id);
        else
            return null;
    }

    public void deleteById(Long id){
        projectTaskRepository.deleteById(id);
    }





}
