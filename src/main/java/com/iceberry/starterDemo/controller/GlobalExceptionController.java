package com.iceberry.starterDemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获和处理器
 */
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * 处理Exception异常
     * @param e 发生的异常
     * @return 处理后应响应的信息
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        String msg = String.format("[Error]%s", e.getMessage());
        return msg;
    }
}
