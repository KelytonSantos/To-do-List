package com.list.to_do.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.list.to_do.DTO.TaskSharedDTO;
import com.list.to_do.entities.TaskShared;
import com.list.to_do.service.TaskSharedService;

@RestController
@RequestMapping("/task/share")
public class TaskSharedController {

    @Autowired
    private TaskSharedService taskSharedService;

    @GetMapping
    public ResponseEntity<List<TaskShared>> getAll() {
        return ResponseEntity.ok().body(taskSharedService.getAll());
    }

    @PostMapping
    public ResponseEntity<TaskShared> taskToShare(@RequestBody TaskSharedDTO taskSharedDTO) {
        TaskShared taskShared = taskSharedService.shareTask(taskSharedDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(taskShared.getId()).toUri();
        return ResponseEntity.created(uri).body(taskShared);
    }

}
