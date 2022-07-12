package com.iceberry.starterDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "连通性测试组")
@RestController
public class HelloController {

    @ApiOperation("连通性测试")
    @GetMapping("/hello")
    public String helloHandler() {
        return "Hello";
    }
}
