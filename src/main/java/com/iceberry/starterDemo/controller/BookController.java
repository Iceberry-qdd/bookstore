package com.iceberry.starterDemo.controller;

import com.iceberry.starterDemo.model.BookModel;
import com.iceberry.starterDemo.model.ListData;
import com.iceberry.starterDemo.model.ResponseVO;
import com.iceberry.starterDemo.service.BookService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "书籍信息组")
@RestController
public class BookController {
    @Resource(name = "bookService")
    BookService bookService;

    /**
     * 分页获取所有书的信息
     *
     * @param page     第几页
     * @param pageSize 每页多少条
     * @param request  http请求对象
     * @param response http响应对象
     * @return 响应实体类
     */
    @ApiOperation("分页查询书籍信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "带查询的页码", required = true, paramType = "path", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "s", value = "每页条目数量", required = true, paramType = "query", dataType = "Integer", defaultValue = "10")})
    @GetMapping("/book/{page}")
    public ResponseVO<ListData<List<BookModel>>> getBookListHandler(@PathVariable int page, @RequestParam("s") int pageSize, HttpServletRequest request, HttpServletResponse response) {

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
    @ApiOperation("新增单个书籍信息")
    @PutMapping("/book")
    public ResponseVO<BookModel> createOneBookHandler(@ApiParam("待新增的书籍信息实体") @RequestBody BookModel bookModel, HttpServletRequest request, HttpServletResponse response) {
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
    @ApiOperation("修改单个书籍信息")
    @PostMapping("/book")
    public ResponseVO<BookModel> updateOneBookHandler(@ApiParam("待修改的书籍信息实体") @RequestBody BookModel bookModel, HttpServletRequest request, HttpServletResponse response) {
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
    @ApiOperation("删除单个书籍信息")
    @DeleteMapping("/book")
    public ResponseVO<BookModel> deleteOneBookHandler(@ApiParam("待删除的书籍信息实体") @RequestBody BookModel bookModel, HttpServletRequest request, HttpServletResponse response) {
        BookModel data = bookService.deleteOne(bookModel);
        return new ResponseVO<>(HttpServletResponse.SC_OK, 0, data, request.getRequestURI());
    }
}
