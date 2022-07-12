package com.iceberry.starterDemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        String msg = String.format("[Error]%s", e.getMessage());
        return msg;
    }
}
