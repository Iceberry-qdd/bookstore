package com.iceberry.starterDemo.model;

public class ListData<T> {
    int totalPage;
    long totalSize;
    int curPage;
    int pageSize;
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
