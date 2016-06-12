package com.twu.biblioteca.others;


/**
 * Created by cxzhao on 6/6/16.
 */
public class Book {
    private String name;
    private String author;
    private Integer year;
    private Boolean isCheckout;

    public String getName() {
        return name;
    }

    public Boolean getCheckout() {
        return isCheckout;
    }

    public void setCheckout(Boolean checkout) {
        isCheckout = checkout;
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
