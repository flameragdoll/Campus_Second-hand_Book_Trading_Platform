package com.findman.restapi.domain;

/*public class User {

    private Long id;
    private String name;
    private Integer age;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}*/

import java.util.Scanner;

public class User {
    private String name;

    public void browse() {
        System.out.println(this.name + "浏览了书籍列表");
        BookList bookList = BookList.GetBookList();
        bookList.display();
    }

    public void post(Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("title：");
        String title = scanner.nextLine();
        System.out.print("author：");
        String author = scanner.nextLine();
        System.out.print("press：");
        String press = scanner.nextLine();
        System.out.print("price：");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.print("condition：");
        String condition = scanner.nextLine();
        Book book = new Book(title, author, press, price, condition, this.getName());
        BookList bookList = BookList.GetBookList();
        bookList.add(book);
        System.out.println("用户" + this.name + "发布了一本书籍：" + book);
        group.NotifyUser(this.name, book.getTitle());
    }

    public void post(Book book, Group group) {
        BookList bookList = BookList.GetBookList();
        bookList.add(book);
        System.out.println("用户" + this.name + "发布了一本书籍：" + book);
        group.NotifyUser(this.name, book.getTitle());
    }

    public void onlook() {
        System.out.println(this.name + " 前来围观啦！");
    }

    public String getName() {
        return name;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

}

