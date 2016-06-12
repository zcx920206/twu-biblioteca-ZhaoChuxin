package com.twu.biblioteca.MVC;

import com.twu.biblioteca.others.User;

import java.util.Scanner;

/**
 * Created by cxzhao on 6/8/16.
 */
public class Controller {
    private Model model;
    private View view;
    private String optionString;
    private String continueOptionString;
    private String libraryNumber;
    private String password;
    private int identify;

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        int i = 0;
        if (this.identify != 0) {
            do {
                if (i > 0) this.view.displayWarn();
                {
                    this.view.displayMenu(this.identify);
                    this.view.displayOption();
                    this.optionString = inputOption();
                    i++;
                    break;
                }
            }
            while (!this.optionString.matches("^[0-9]*$") || (Integer.parseInt(this.optionString) > 9 || Integer.parseInt(this.optionString) < 1));
        }

        executeSelect(optionString);
    }

    public static String inputOption() {
        Scanner in = new Scanner(System.in);
        String option = in.next();
        return option;
    }

    public void executeSelect(String optionString) {
        int selectOption = Integer.parseInt(optionString);
        if (this.identify == 2) {
            switch (selectOption) {
                case 1:
                    this.view.displayBooks(this.model.getBooks());
                    break;
                case 2:
                    this.view.displayInputBookSerail();
                    this.model.checkoutBook(inputOption(), libraryNumber);
                    break;
                case 3:
                    this.view.displayInputBookSerail();
                    this.model.returnBook(inputOption(), libraryNumber);
                    break;
                case 4:
                    this.view.displayMovies(this.model.getAllMovies());
                    break;
                case 5:
                    this.view.displayInputMovieSerail();
                    this.model.checkoutMovie(inputOption(), libraryNumber);
                case 6:
                    this.view.displayInputMovieSerail();
                    this.model.returnMovies(inputOption(), libraryNumber);
                    break;
                case 7:
                    this.view.diplayPerInfo(libraryNumber, model.users);
                case 8:
                    this.view.displayWelcomeMessage();
                    login();
                    start();
                case 9:
                    this.view.displayQuit();
                    break;
            }
        }
        if (this.identify == 1) {
            switch (selectOption) {
                case 1:
                    this.view.displayCheckoutInfo(model.users);
                    break;
                case 2:
                    this.view.displayWelcomeMessage();
                    login();
                    start();
                    break;
                case 3:
                    this.view.displayQuit();
                    break;
            }
        }
        if ((this.identify == 2 && selectOption != 9) || (this.identify == 1 && selectOption != 3)) {
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

    public int login() {
        boolean isNotLogin = true;
        do {
            view.displayInputLibraryNumber();
            this.libraryNumber = inputOption();
            view.displayInputPassword();
            this.password = inputOption();
            for (User user : this.model.users) {
                if (this.libraryNumber.equals(user.getLibraryNumber()) && this.password.equals(user.getPassWord())) {
                    this.identify = user.getIdentify();
                    return user.getIdentify();
                }
            }
        } while (isNotLogin);
        return 0;
    }
}
