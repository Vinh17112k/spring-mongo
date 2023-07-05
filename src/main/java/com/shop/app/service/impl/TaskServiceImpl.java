package com.shop.app.service.impl;

import com.shop.app.entity.Task;
import com.shop.app.repository.TaskRepository;
import com.shop.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE

    @Override

    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }
    @Override
    public List<Task> findAllTasks() {
        return repository.findAll();
    }
    @Override
    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }
    @Override
    public List<Task> getTaskBySeverity(int severity){
        return  repository.findBySeverity(severity);
    }
    @Override
    public List<Task> getTaskByAssignee(String assignee){
        return repository.getTasksByAssignee(assignee);
    }
    @Override
    public Task updateTask(Task taskRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return repository.save(existingTask);
    }
    @Override
    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId+" task deleted from dashboard ";
    }
}
