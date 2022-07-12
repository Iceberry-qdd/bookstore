package com.iceberry.starterDemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 列表信息封装类，主要是为数据列表增加页数相关信息
 * @param <T> 数据列表
 */
@ApiModel("列表信息封装类")
public class ListData<T> {
    @ApiModelProperty("列表总页数")
    int totalPage;
    @ApiModelProperty("列表条目总数")
    long totalSize;
    @ApiModelProperty("当前页数")
    int curPage;
    @ApiModelProperty("每页条目数量")
    int pageSize;
    @ApiModelProperty("列表数据")
    T data;

    public ListData(int totalPage, long totalSize, int curPage, int pageSize, T data) {
        this.totalPage = totalPage;
        this.totalSize = totalSize;
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.data = data;
    }

    public ListData() {
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
