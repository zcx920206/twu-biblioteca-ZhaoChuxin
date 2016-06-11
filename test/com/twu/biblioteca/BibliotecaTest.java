package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private Model model;
    private View view;
    private Controller controller;

    @Before
    public void set_up(){
         model=new Model();
        view=new View();
       controller=new Controller(view,model);
    }

    @Test
    public void shouldCheckoutSuccessWhenInputRight() {
       assertEquals(true,model.checkoutBook(returnKey()));
    }

    @Test
    public void shouldCheckoutFailWhenInputRight() {
        assertEquals(false,model.checkoutBook("abc"));
    }

    @Test
    public void shouldReturnBookSuccessWhenInputRight() throws Exception {
        String key=returnKey();
        model.checkoutBook(key);
     assertEquals(true,model.returnBook(key));
    }

    @Test
    public void shouldReturnBookFailWhenInputWrong() throws Exception {
        assertEquals(false,model.returnBook(returnKey()));
    }




    public String returnKey(){
        String key=new String();
        for (Map.Entry<String, Book> entry : model.getBooks().entrySet()){
            key=entry.getKey();
            break;
        }
        return key;
    }

}
