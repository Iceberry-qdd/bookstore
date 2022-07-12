package com.iceberry.starterDemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "书籍实体类")
public class BookModel {
    @ApiModelProperty("书籍编号")
    int id;
    @ApiModelProperty("书籍名称")
    String name;
    @ApiModelProperty("书籍ISBN号")
    String isbn;

    @ApiModelProperty("出版日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date publishDate;
    @ApiModelProperty("出版社名称")
    String publisherName;
    @ApiModelProperty("书籍总页数")
    int pageCount;
    @ApiModelProperty("作者")
    String authorName;
    @ApiModelProperty("封面图片地址")
    String coverImgUrl;
    @ApiModelProperty("书籍类型")
    int type; //类别

    public BookModel() {
    }

    public BookModel(int id, String name, String isbn, Date publishDate, String publisherName, int pageCount, String authorName, String coverImgUrl, int type) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.publisherName = publisherName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.coverImgUrl = coverImgUrl;
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
