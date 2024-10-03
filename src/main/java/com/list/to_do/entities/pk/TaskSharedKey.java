package com.list.to_do.entities.pk;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class TaskSharedKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private String taskId;
    private String userId;
}
