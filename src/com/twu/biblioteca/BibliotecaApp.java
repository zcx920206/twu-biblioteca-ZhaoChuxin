package com.twu.biblioteca;

import com.twu.biblioteca.controller.Controller;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.Print;

public class BibliotecaApp {
    public static void main(String[] args) {
        Library library = new Library();
        Print print = new Print();
        Controller controller = new Controller(print, library);

        print.displayWelcomeMessage();
        controller.setIdentify(controller.login());
        controller.start();
    }
}
