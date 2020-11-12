package com.findman.restapi.domain;

public class Book {
    private String title;//书名
    private String author;//作者
    private String press;//出版社
    private float price;//价格
    private String condition;//新旧程度
    private String seller;//卖家

    public Book() {
    }

    public Book(String title, String author, String press, float price, String condition, String seller) {
        this.title = title;
        this.author = author;
        this.press = press;
        this.price = price;
        this.condition = condition;
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", price='" + price + '\'' +
                ", condition='" + condition + '\'' +
                ", seller=" + seller +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
