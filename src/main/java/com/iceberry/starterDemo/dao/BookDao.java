package com.iceberry.starterDemo.dao;

import com.iceberry.starterDemo.model.BookModel;
import com.iceberry.starterDemo.model.ListData;
import com.iceberry.starterDemo.model.jpa.BookEntity;
import com.iceberry.starterDemo.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookDao {
    List<BookModel> data = new ArrayList<>();

    @Resource(name = "bookRepository")
    BookRepository bookRepository;

    /**
     * 从数据库中分页查询书籍列表信息
     *
     * @param page     要查询的页数
     * @param pageSize 每页条目数量
     * @return 书籍列表
     */
    public ListData<List<BookEntity>> findAll(int page, int pageSize) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);
        while (true) {
            Slice<BookEntity> slice = bookRepository.findAll(pageable);
            List<BookEntity> list = slice.getContent();
            if (!slice.hasNext()) break;
            pageable=slice.nextPageable();
        }


        Page<BookEntity> bookPage = bookRepository.findAll(pageable);
        List<BookEntity> bookList = bookPage.getContent();
        int totalPages = bookPage.getTotalPages();
        long totalSize = bookPage.getTotalElements();
        return new ListData<>(totalPages, totalSize, page, pageSize, bookList);
    }

    /**
     * 向数据库中插入一条书籍信息
     *
     * @param bookModel 要添加的书籍信息
     * @return 添加完的结果
     */
    public BookEntity insertOne(BookModel bookModel) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookModel, bookEntity);
        bookEntity.setCreatedAt(new Date(System.currentTimeMillis()));
        return bookRepository.save(bookEntity);
    }

    /**
     * 向数据库中更新一条书籍信息
     *
     * @param bookModel 要更新的书籍信息
     * @return 更新完的结果
     */
    public BookEntity updateOne(BookModel bookModel) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookModel, bookEntity);
        bookEntity.setUpdatedAt(new Date(System.currentTimeMillis()));
        return bookRepository.save(bookEntity);
    }

    /**
     * 删除数据库中的一条书籍信息
     *
     * @param bookModel 要删除的书籍信息
     * @return 删除掉的数据项
     */
    public BookEntity deleteOne(BookModel bookModel) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookModel, bookEntity);
        bookEntity.setDeletedAt(new Date(System.currentTimeMillis()));
        return bookRepository.save(bookEntity);
    }
}
