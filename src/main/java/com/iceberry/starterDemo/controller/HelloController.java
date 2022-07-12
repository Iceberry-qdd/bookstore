package com.iceberry.starterDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 连通性测试接口
 */
@Api(tags = "连通性测试组")
@RestController
public class HelloController {

    /**
     * 连通性测试接口
     * @return 响应字符串
     */
    @ApiOperation("连通性测试")
    @GetMapping("/ping")
    public String helloHandler() {
        return "pong";
    }
}
