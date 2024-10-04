package com.list.to_do.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.list.to_do.DTO.TaskDTO;
import com.list.to_do.entities.Task;
import com.list.to_do.entities.User;
import com.list.to_do.entities.ENUM.PriorityTask;
import com.list.to_do.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task creatTask(TaskDTO data) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();
        Task newTask = new Task(data.taskName(), data.taskDescription(), data.validityTime(),
                PriorityTask.valueOf(data.priorityTask()));
    }

    // criar task

}
