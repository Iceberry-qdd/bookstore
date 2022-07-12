package com.iceberry.starterDemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("响应实体类")
public class ResponseVO<T> implements Serializable {
    static final long serialVersionUID = 42L;
    @ApiModelProperty("http响应状态码")
    int statusCode;
    @ApiModelProperty("业务响应状态码")
    int code;
    @ApiModelProperty("响应数据")
    T data;

    @ApiModelProperty("响应时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date timestamps;
    @ApiModelProperty("请求路径")
    String url;

    public ResponseVO(int statusCode, int code, T data, String url) {
        this.statusCode = statusCode;
        this.code = code;
        this.data = data;
        this.url = url;
        this.timestamps = new Date();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
