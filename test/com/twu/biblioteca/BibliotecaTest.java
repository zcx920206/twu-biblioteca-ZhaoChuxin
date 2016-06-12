package com.twu.biblioteca;


import com.twu.biblioteca.MVC.Controller;
import com.twu.biblioteca.MVC.Model;
import com.twu.biblioteca.MVC.View;
import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Movie;
import com.twu.biblioteca.others.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private Model model;
    private View view;
    private User user;
    private Controller controller;

    @Before
    public void set_up(){
         model=new Model();
        view=new View();
       controller=new Controller(view,model);
    }

    @Test
    public void shouldCheckoutBookSuccessWhenInputRight() {
       assertEquals(true,model.checkoutBook(returnBookKey(),returnLibraryNumber()));
    }

    @Test
    public void shouldCheckoutBookFailWhenInputRight() {
        assertEquals(false,model.checkoutBook("abc",returnLibraryNumber()));
    }

    @Test
    public void shouldReturnBookSuccessWhenInputRight() throws Exception {
        String key=returnBookKey();
        model.checkoutBook(key,returnLibraryNumber());
     assertEquals(true,model.returnBook(key,returnLibraryNumber()));
    }

    @Test
    public void shouldReturnBookFailWhenInputWrong() throws Exception {
        assertEquals(false,model.returnMovies(returnBookKey(),returnLibraryNumber()));
    }
    @Test
    public void shouldCheckoutMovieSuccessWhenInputRight() {
        assertEquals(true,model.checkoutMovie(returnMovieKey(),returnLibraryNumber()));
    }

    @Test
    public void shouldCheckoutMovieFailWhenInputRight() {
        assertEquals(false,model.checkoutMovie("abc",returnLibraryNumber()));
    }

    @Test
    public void shouldReturnMovieSuccessWhenInputRight() throws Exception {
        String key=returnMovieKey();
        model.checkoutMovie(key,returnLibraryNumber());
        assertEquals(true,model.returnMovies(key,returnLibraryNumber()));
    }

    @Test
    public void shouldReturnMovieFailWhenInputWrong() throws Exception {
        assertEquals(false,model.returnMovies(returnMovieKey(),returnLibraryNumber()));
    }


    public String returnBookKey(){
        String key=new String();
        for (Map.Entry<String, Book> entry : model.getBooks().entrySet()){
            key=entry.getKey();
            break;
        }
        return key;
    }
    public String returnMovieKey(){
        String key=new String();
        for (Map.Entry<String, Movie> entry : model.getAllMovies().entrySet()){
            key=entry.getKey();
            break;
        }
        return key;
    }
    public String returnLibraryNumber(){
        String libraryNumber=model.users.get(0).getLibraryNumber();
        return libraryNumber;
    }

}
