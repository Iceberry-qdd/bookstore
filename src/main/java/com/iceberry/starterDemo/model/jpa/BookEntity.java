package com.iceberry.starterDemo.model.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Comment;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_book_info")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "书的编号")
    private int id;

    @Column(name = "name", length = 50)
    @Comment(value = "书的名称")
    private String name;
    @Column
    @Comment(value = "ISBN编号")
    private String isbn;
    @Column
    @Comment(value = "作者名称")
    private String authorName;
    @Column
    @Comment(value = "出版日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;
    @Column
    @Comment(value = "出版社名称")
    private String publisherName;
    @Column
    @Comment(value = "封面图片路径")
    private String coverImgUrl;
    @Column
    @Comment(value = "总页数")
    private int pageCount;

    @Column
    @Comment(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @Column
    @Comment(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @Column
    @Comment(value = "删除时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deletedAt;

    public BookEntity() {
    }

    public BookEntity(int id, String name, String isbn, String authorName, Date publishDate, String publisherName, String coverImgUrl, int pageCount) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.publisherName = publisherName;
        this.coverImgUrl = coverImgUrl;
        this.pageCount = pageCount;
        //this.createdAt=new Date(System.currentTimeMillis());
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createAt) {
        this.createdAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updateAt) {
        this.updatedAt = updateAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
