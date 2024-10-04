package com.list.to_do.entities.pk;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class TaskSharedKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private String taskId;
    private String userId;
}
