package com.iceberry.starterDemo.service;

import com.iceberry.starterDemo.dao.BookDao;
import com.iceberry.starterDemo.model.BookModel;
import com.iceberry.starterDemo.model.ListData;
import com.iceberry.starterDemo.model.jpa.BookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookService {

    @Resource(name = "bookDao")
    BookDao bookDao;

    /**
     * 从数据库中分页查询书籍列表信息
     *
     * @param page     要查询的页数
     * @param pageSize 每页条目数量
     * @return 书籍列表
     */
    public ListData<List<BookModel>> getAll(int page, int pageSize) {
        ListData<List<BookModel>> bookModelList = new ListData<>();
        ListData<List<BookEntity>> bookEntityList = bookDao.findAll(page, pageSize);
        BeanUtils.copyProperties(bookEntityList, bookModelList);
        return bookModelList;
    }

    /**
     * 向数据库中插入一条书籍信息
     *
     * @param bookModel 要添加的书籍信息
     * @return 添加完的结果
     */
    public BookModel insertOne(BookModel bookModel) {
        BookEntity bookEntity = bookDao.insertOne(bookModel);
        bookModel = new BookModel();
        BeanUtils.copyProperties(bookEntity, bookModel);
        return bookModel;
    }

    /**
     * 向数据库中更新一条书籍信息
     *
     * @param bookModel 要更新的书籍信息
     * @return 更新完的结果
     */
    public BookModel updateOne(BookModel bookModel) {
        BookEntity bookEntity = bookDao.updateOne(bookModel);
        bookModel = new BookModel();
        BeanUtils.copyProperties(bookEntity, bookModel);
        return bookModel;
    }

    /**
     * 删除数据库中的一条书籍信息
     *
     * @param bookModel 要删除的书籍信息
     * @return 删除掉的数据项
     */
    public BookModel deleteOne(BookModel bookModel) {
        BookEntity bookEntity = bookDao.deleteOne(bookModel);
        bookModel = new BookModel();
        BeanUtils.copyProperties(bookEntity, bookModel);
        return bookModel;
    }
}
