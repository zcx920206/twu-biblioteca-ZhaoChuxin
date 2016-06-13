package com.twu.biblioteca.model;


/**
 * Created by cxzhao on 6/6/16.
 */
public class Book {
    private String name;
    private String author;
    private Integer year;

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setInfo(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
}
