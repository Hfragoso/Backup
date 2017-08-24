package com.example.admin.w5d2_ex01;

/**
 * Created by Admin on 8/15/2017.
 */

public class HelloWorldEvent {
    private final String message;

    public HelloWorldEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
