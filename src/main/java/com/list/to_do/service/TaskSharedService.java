package com.list.to_do.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.list.to_do.entities.Task;
import com.list.to_do.entities.TaskShared;
import com.list.to_do.entities.User;
import com.list.to_do.exceptions.ResourceAlreadyExist;
import com.list.to_do.repositories.TaskSharedRepository;

@Service
public class TaskSharedService {

    @Autowired
    private TaskSharedRepository taskSharedRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    public TaskShared shareTask(String email, UUID id) {
        User user = userService.findActiveByEmail(email);
        Task task = taskService.getById(id);

        if (taskSharedRepository.existsByTaskAndUser(id, user.getId())) {
            throw new ResourceAlreadyExist("Conflict");
        }

        TaskShared taskToShare = new TaskShared();
        taskToShare.setUser(user);
        taskToShare.setTask(task);

        return taskSharedRepository.save(taskToShare);
    }

}
