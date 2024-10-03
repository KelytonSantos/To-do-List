package com.list.to_do.entities;

import com.list.to_do.entities.ENUM.AccessLevel;
import com.list.to_do.entities.pk.TaskSharedKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_task_shared")
public class TaskShared {

    @EmbeddedId
    private TaskSharedKey id;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id") // informando ao JPA que o ID da task presente em TaskSharedKey deve ser o mesmo
                                  // ID da entidade Task que está associada na entidade TaskShared.
    private Task task;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    private AccessLevel accessLevel;
}
