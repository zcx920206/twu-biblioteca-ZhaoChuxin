package com.twu.biblioteca;

import com.twu.biblioteca.MVC.Controller;
import com.twu.biblioteca.MVC.Model;
import com.twu.biblioteca.MVC.View;

public class BibliotecaApp {
    public static void main(String[] args) {
        Model model=new Model();
        View view=new View();
        Controller controller=new Controller(view,model);
        view.displayWelcomeMessage();
        controller.setIdentify(controller.login());
        controller.start();
    }
}
