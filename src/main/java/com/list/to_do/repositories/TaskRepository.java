package com.list.to_do.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.list.to_do.entities.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
