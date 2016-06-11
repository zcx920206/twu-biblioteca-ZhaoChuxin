package com.twu.biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        Model model=new Model();
        View view=new View();
        Controller controller=new Controller(view,model);
        view.displayWelcomeMessage();
        controller.start();
    }
}
