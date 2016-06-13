package com.twu.biblioteca;


import com.twu.biblioteca.controller.Controller;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.Print;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private Library library;
    private Print print;
    private User user;
    private Controller controller;

    @Before
    public void set_up() {
        library = new Library();
        print = new Print();
        controller = new Controller(print, library);
    }

    @Test
    public void shouldCheckoutBookSuccessWhenInputRight() {
        assertEquals(true, library.checkoutBook(returnBookKey(), returnLibraryNumber()));
    }

    @Test
    public void shouldCheckoutBookFailWhenInputRight() {
        assertEquals(false, library.checkoutBook("abc", returnLibraryNumber()));
    }

    @Test
    public void shouldReturnBookSuccessWhenInputRight() throws Exception {
        String key = returnBookKey();
        library.checkoutBook(key, returnLibraryNumber());
        assertEquals(true, library.returnBook(key, returnLibraryNumber()));
    }

    @Test
    public void shouldReturnBookFailWhenInputWrong() throws Exception {
        assertEquals(false, library.returnMovies(returnBookKey(), returnLibraryNumber()));
    }

    @Test
    public void shouldCheckoutMovieSuccessWhenInputRight() {
        assertEquals(true, library.checkoutMovie(returnMovieKey(), returnLibraryNumber()));
    }

    @Test
    public void shouldCheckoutMovieFailWhenInputRight() {
        assertEquals(false, library.checkoutMovie("abc", returnLibraryNumber()));
    }

    @Test
    public void shouldReturnMovieSuccessWhenInputRight() throws Exception {
        String key = returnMovieKey();
        library.checkoutMovie(key, returnLibraryNumber());
        assertEquals(true, library.returnMovies(key, returnLibraryNumber()));
    }

    @Test
    public void shouldReturnMovieFailWhenInputWrong() throws Exception {
        assertEquals(false, library.returnMovies(returnMovieKey(), returnLibraryNumber()));
    }


    public String returnBookKey() {
        String key = new String();
        for (Map.Entry<String, Book> entry : library.getAllBooks().entrySet()) {
            key = entry.getKey();
            break;
        }
        return key;
    }

    public String returnMovieKey() {
        String key = new String();
        for (Map.Entry<String, Movie> entry : library.getAllMovies().entrySet()) {
            key = entry.getKey();
            break;
        }
        return key;
    }

    public String returnLibraryNumber() {
        String libraryNumber = library.users.get(0).getLibraryNumber();
        return libraryNumber;
    }

}
