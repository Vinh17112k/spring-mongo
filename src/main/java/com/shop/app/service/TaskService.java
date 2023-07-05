package com.shop.app.service;

import com.shop.app.entity.Task;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);

    List<Task> findAllTasks();

    Task getTaskByTaskId(String taskId);

    List<Task> getTaskBySeverity(int severity);

    List<Task> getTaskByAssignee(String assignee);

    Task updateTask(Task taskRequest);

    String deleteTask(String taskId);
}
