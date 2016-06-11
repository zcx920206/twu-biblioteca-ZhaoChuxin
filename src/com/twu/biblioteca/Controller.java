package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by cxzhao on 6/8/16.
 */
public class Controller {
    private Model model;
    private View view;
    private String optionString = new String();
    private String continueOptionString = new String();

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        int i = 0;
        do {
            if (i > 0) this.view.displayWarn();
            this.view.displayMenu();
            this.view.displayOption();
            this.optionString = inputOption();
            i++;
        }
        while (!this.optionString.matches("^[0-9]*$") || (Integer.parseInt(this.optionString) > 4 || Integer.parseInt(this.optionString) < 1));
        executeSelect(optionString);
    }

    public static String inputOption() {
        Scanner in = new Scanner(System.in);
        String option = in.next();
        return option;
    }

    public void executeSelect(String optionString) {
        int selectOption = Integer.parseInt(optionString);
        switch (selectOption) {
            case 1:
                this.view.displayBooks(this.model.getBooks());
                break;
            case 2:
                this.view.displayInputBookSerail();
                this.model.checkoutBook(inputOption());
                break;
            case 3:
                this.view.displayInputBookSerail();
                this.model.returnBook(inputOption());
                break;
            case 4:
                this.view.displayQuit();
                break;
        }
        if (selectOption!=4) {
            int continueOption = continueSelect();
            if (continueOption == 1) start();
            else if (continueOption == 2) this.view.displayQuit();
        }
    }

    public int continueSelect() {
        int i = 0;
        do {
            if (i > 0) this.view.displayWarn();
            this.view.displayContinueOption();
            continueOptionString = inputOption();
            i++;
        }
        while (!continueOptionString.matches("^[0-9]*$") || (Integer.parseInt(continueOptionString) > 2 || Integer.parseInt(continueOptionString) < 1));

        return Integer.parseInt(continueOptionString);
    }
}
