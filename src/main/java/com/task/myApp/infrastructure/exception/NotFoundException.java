package com.task.myApp.infrastructure.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private final String title;
    private final String detail;

    public NotFoundException(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}
