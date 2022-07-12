package com.iceberry.starterDemo.controller;

import com.iceberry.starterDemo.model.BookModel;
import com.iceberry.starterDemo.model.ListData;
import com.iceberry.starterDemo.model.ResponseVO;
import com.iceberry.starterDemo.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BookController {
    @Resource(name = "bookService")
    BookService bookService;

    /**
     * 分页获取所有书得信息
     *
     * @param page     第几页
     * @param pageSize 每页多少条
     * @param request  http请求对象
     * @param response http响应对象
     * @return 响应实体类
     */
    @GetMapping("/book/{page}")
    public ResponseVO<ListData<List<BookModel>>> getBookList(@PathVariable int page, @RequestParam("s") int pageSize, HttpServletRequest request, HttpServletResponse response) {

        ListData<List<BookModel>> data = bookService.getAll(page, pageSize);
        return new ResponseVO<>(HttpServletResponse.SC_OK, 0, data, request.getRequestURI());
    }

    /**
     * 向数据库插入一条书籍信息
     *
     * @param bookModel 要插入的书籍对象
     * @param request   http请求对象
     * @param response  http响应对象
     * @return 响应实体类
     */
    @PutMapping("/book")
    public ResponseVO<BookModel> createOneBook(@RequestBody BookModel bookModel, HttpServletRequest request, HttpServletResponse response) {
        BookModel data = bookService.insertOne(bookModel);
        return new ResponseVO<>(HttpServletResponse.SC_OK, 0, data, request.getRequestURI());
    }

    /**
     * 更新数据库中的一条书籍信息
     *
     * @param bookModel 要更新的书籍对象
     * @param request   http请求对象
     * @param response  http响应对象
     * @return 响应实体类
     */
    @PostMapping("/book")
    public ResponseVO<BookModel> updateOneBook(@RequestBody BookModel bookModel, HttpServletRequest request, HttpServletResponse response) {
        BookModel data = bookService.updateOne(bookModel);
        return new ResponseVO<>(HttpServletResponse.SC_OK, 0, data, request.getRequestURI());
    }

    /**
     * 删除数据库中的一条书籍信息
     *
     * @param bookModel 要删除的书籍对象
     * @param request   http请求对象
     * @param response  http响应对象
     * @return 响应实体类
     */
    @DeleteMapping("/book")
    public ResponseVO<BookModel> deleteOneBook(@RequestBody BookModel bookModel, HttpServletRequest request, HttpServletResponse response) {
        BookModel data = bookService.deleteOne(bookModel);
        return new ResponseVO<>(HttpServletResponse.SC_OK, 0, data, request.getRequestURI());
    }
}
