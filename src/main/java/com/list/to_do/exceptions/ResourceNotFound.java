package com.list.to_do.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(Object id) {
        super(id.toString());
    }
}
