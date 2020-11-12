package com.findman.restapi.domain;

import java.util.ArrayList;

public class BookList {
    //私有静态成员变量，存储唯一实例
    private static BookList instance = null;
    //书籍列表
    private ArrayList<Book> list = null;

    //私有构造函数
    private BookList() {
        this.list = new ArrayList<Book>();
    }

    //公有静态成员方法，返回唯一实例
    public static BookList GetBookList() {
        if (instance == null) {
            instance = new BookList();
        }
        return instance;
    }

    public void add(Book book) {
        list.add(book);
    }

    public void display() {
        for (Book book : list)
            System.out.println(book);
    }
}
