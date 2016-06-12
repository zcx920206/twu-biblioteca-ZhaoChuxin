package com.twu.biblioteca.MVC;

import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Movie;
import com.twu.biblioteca.others.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cxzhao on 6/6/16.
 */
public class Model {
    public Map<String, Book> allBooks = new TreeMap<>();
    public Map<String, Book> checkoutBooks = new TreeMap<>();
    public Map<String, Movie> allMovies = new TreeMap<>();
    public Map<String, Movie> checkoutMovies = new TreeMap<>();
    public List<User> users = new ArrayList<>();

    public Model() {
        Book book1 = new Book();
        book1.setInfo("Wuthering Heights", "Emily Bronte", 1900);
        this.allBooks.put("NO.B01", book1);
        Book book2 = new Book();
        book2.setInfo("Treasure Island", "Robert Louis Stevenson", 1830);
        this.allBooks.put("NO.B02", book2);
        Book book3 = new Book();
        book3.setInfo("Gone with the wind", "Margaret Mitchell", 1935);
        this.allBooks.put("NO.B03", book3);
        Book book4 = new Book();
        book4.setInfo("The Wizard of Oz", "Lyman Frank Baum", 1827);
        this.allBooks.put("NO.B04", book4);
        Book book5 = new Book();
        book5.setInfo("Robinson Crusoe", "Daniel Defoe", 1711);
        this.allBooks.put("NO.B05", book5);
        Movie movie1 = new Movie();
        movie1.setInfo("The Godfather", 1972, "Francis Ford Coppola", "2");
        this.allMovies.put("NO.M01", movie1);
        Movie movie2 = new Movie();
        movie2.setInfo("The Shawshank Redemption", 1994, "Stephen Edwin King", "6");
        this.allMovies.put("NO.M02", movie2);
        Movie movie3 = new Movie();
        movie3.setInfo("Star Wars ", 1977, "George Lucas", "9");
        this.allMovies.put("NO.M003", movie3);
        User customer = new User("Lily", "123456@123.com", "13451236789", "qwe-zxc", "123456", 2);
        User librarian = new User("Sarah", "111111@123.com", "134111111", "poi-mnb", "111111", 1);
        this.users.add(customer);
        this.users.add(librarian);
    }

    public Map<String, Book> getBooks() {
        return allBooks;
    }

    public Map<String, Movie> getAllMovies() {
        return allMovies;
    }

    public Boolean checkoutBook(String option, String libraryNumber) {
        Boolean isCheckout = false;
        for (Map.Entry<String, Book> entry : this.allBooks.entrySet()) {
            if (entry.getKey().equals(option)) {
                this.checkoutBooks.put(entry.getKey(), entry.getValue());
                this.allBooks.remove(entry.getKey(), entry.getValue());
                for (User user : this.users) {
                    if (libraryNumber.equals(user.getLibraryNumber()))
                        user.getCheckoutBookName().add(entry.getValue().getName());
                }
                isCheckout = true;
                System.out.println("Thank you! Enjoy the book");
                break;
            }
        }
        if (isCheckout == false)
            System.out.println("That book is not available.");
        return isCheckout;
    }

    public Boolean checkoutMovie(String option, String libraryNumber) {
        Boolean isCheckout = false;
        for (Map.Entry<String, Movie> entry : this.allMovies.entrySet()) {
            if (entry.getKey().equals(option)) {
                this.checkoutMovies.put(entry.getKey(), entry.getValue());
                this.allMovies.remove(entry.getKey(), entry.getValue());
                for (User user : this.users) {
                    if (libraryNumber.equals(user.getLibraryNumber()))
                        user.getCheckoutMovieName().add(entry.getValue().getName());
                }
                isCheckout = true;
                System.out.println("Thank you! Enjoy the movie");
                break;
            }
        }
        if (isCheckout == false)
            System.out.println("That movie is not available.");
        return isCheckout;
    }

    public Boolean returnBook(String option, String libraryNumber) {
        Boolean isReturn = false;
        for (Map.Entry<String, Book> bookEntry : this.checkoutBooks.entrySet()) {
            if (bookEntry.getKey().equals(option)) {
                isReturn = true;
                this.allBooks.put(bookEntry.getKey(), bookEntry.getValue());
                this.checkoutBooks.remove(bookEntry.getKey());
                for (User user : this.users) {
                    if (libraryNumber.equals(user.getLibraryNumber()))
                        user.getCheckoutBookName().remove(bookEntry.getValue().getName());
                }
                System.out.println("Thank you for returning the book.");
                break;
            }
        }
        if (isReturn == false)
            System.out.println("That is not a valid book to return.");
        return isReturn;
    }

    public Boolean returnMovies(String option, String libraryNumber) {
        Boolean isReturn = false;
        for (Map.Entry<String, Movie> movieEntry : this.checkoutMovies.entrySet()) {
            if (movieEntry.getKey().equals(option)) {
                isReturn = true;
                this.allMovies.put(movieEntry.getKey(), movieEntry.getValue());
                this.checkoutMovies.remove(movieEntry.getKey());
                for (User user : this.users) {
                    if (libraryNumber.equals(user.getLibraryNumber()))
                        user.getCheckoutMovieName().remove(movieEntry.getValue().getName());
                }
                System.out.println("Thank you for returning the movie.");
                break;
            }
        }
        if (isReturn == false)
            System.out.println("That is not a valid movie to return.");
        return isReturn;
    }
}
