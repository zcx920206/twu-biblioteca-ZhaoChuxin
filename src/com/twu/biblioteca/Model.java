package com.twu.biblioteca;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cxzhao on 6/6/16.
 */
public class Model {
    public Map<String, Book> allBooks = new TreeMap<String, Book>();
    public Map<String, Book> checkoutBooks = new TreeMap<String, Book>();

    public Map<String, Book> getCheckoutBooks() {
        return checkoutBooks;
    }

    public void setCheckoutBooks(Map<String, Book> checkoutBooks) {
        this.checkoutBooks = checkoutBooks;
    }

    public Model() {
        Book book1 = new Book();
        book1.setInfo("Wuthering Heights", "Emily Bronte", 1900);
        this.allBooks.put("NO.001", book1);
        Book book2 = new Book();
        book2.setInfo("Treasure Island", "Robert Louis Stevenson", 1830);
        this.allBooks.put("NO.002", book2);
        Book book3 = new Book();
        book3.setInfo("Gone with the wind", "Margaret Mitchell", 1935);
        this.allBooks.put("NO.003", book3);
        Book book4 = new Book();
        book4.setInfo("The Wizard of Oz", "Lyman Frank Baum", 1827);
        this.allBooks.put("NO.004", book4);
        Book book5 = new Book();
        book5.setInfo("Robinson Crusoe", "Daniel Defoe", 1711);
        this.allBooks.put("NO.005", book5);
    }

    public Map<String, Book> getBooks() {
        return allBooks;
    }

    public Boolean checkoutBook(String option) {
        Boolean isCheckout = false;
        for (Map.Entry<String, Book> entry : this.allBooks.entrySet()) {
            if (entry.getKey().equals(option)) {
                this.checkoutBooks.put(entry.getKey(), entry.getValue());
                this.allBooks.remove(entry.getKey(), entry.getValue());
                isCheckout = true;
                System.out.println("Thank you! Enjoy the book");
                break;
            }
        }
        if (isCheckout == false)
            System.out.println("That book is not available.");
        return isCheckout;
    }

    public Boolean returnBook(String option) {
        Boolean isReturn = false;
        for (Map.Entry<String, Book> bookEntry : this.checkoutBooks.entrySet()) {
            if (bookEntry.getKey().equals(option)) {
                isReturn = true;
                this.allBooks.put(bookEntry.getKey(), bookEntry.getValue());
                this.checkoutBooks.remove(bookEntry.getKey());
                System.out.println("Thank you for returning the book.");
                break;
            }
        }
        if (isReturn == false)
            System.out.println("That is not a valid book to return.");
        return isReturn;
    }
}
