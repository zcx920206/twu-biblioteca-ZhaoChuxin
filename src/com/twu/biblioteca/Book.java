package com.twu.biblioteca;


/**
 * Created by cxzhao on 6/6/16.
 */
public class Book {
    String Name;
    String author;
    Integer year;
    Boolean isCheckout;

    public String getName() {
        return Name;
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

    public void setInfo(String Name, String author, int year) {
        this.Name = Name;
        this.author = author;
        this.year = year;
    }
}
