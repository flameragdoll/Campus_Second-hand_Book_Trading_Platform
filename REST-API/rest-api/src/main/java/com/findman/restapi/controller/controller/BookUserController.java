package com.findman.restapi.controller.controller;

import com.findman.restapi.domain.User;
import com.findman.restapi.domain.Book;

import java.util.*;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sencond-hand")     // 通过这里配置使下面的映射都在/sencond-hand下，可去除
public class BookUserController {

    static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());
    static Map<String, Book> books = Collections.synchronizedMap(new HashMap<String, Book>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = {"/{users}"}, method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/{users}", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getName(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String")
    @RequestMapping(value = "/{users}/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name) {
        return users.get(name);
    }


    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String")
    @RequestMapping(value = "/{users}/{name}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String name) {
        users.remove(name);
        return "success";
    }

    @ApiOperation(value = "获取书籍列表", notes = "")
    @RequestMapping(value = {"/{books}"}, method = RequestMethod.GET)
    public List<Book> getBookList() {
        List<Book> b = new ArrayList<Book>(books.values());
        return b;
    }

    @ApiOperation(value = "创建书籍信息", notes = "根据Book对象创建书籍")
    @ApiImplicitParam(name = "book", value = "书籍详细实体book", required = true, dataType = "Book")
    @RequestMapping(value = "/{books}", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        books.put(book.getTitle(), book);
        return "success";
    }

    @ApiOperation(value = "获取书籍详细信息", notes = "根据url的title来获取书籍详细信息")
    @ApiImplicitParam(name = "title", value = "书名", required = true, dataType = "String")
    @RequestMapping(value = "/{books}/{title}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String title) {
        return books.get(title);
    }


    @ApiOperation(value = "删除书籍", notes = "根据url的title来指定删除对象")
    @ApiImplicitParam(name = "title", value = "书名", required = true, dataType = "String")
    @RequestMapping(value = "/{books}/{title}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable String title) {
        books.remove(title);
        return "success";
    }


}
