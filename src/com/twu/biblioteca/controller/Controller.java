package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.Print;
import com.twu.biblioteca.model.User;

import java.util.Scanner;

/**
 * Created by cxzhao on 6/8/16.
 */
public class Controller {
    private Library library;
    private Print print;
    private String optionString;
    private String continueOptionString;
    private String libraryNumber;
    private String password;
    private int identify;

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public Controller(Print print, Library library) {
        this.print = print;
        this.library = library;
    }

    public void start() {
        Boolean isInputCorrect = false;
        do {
            if (isInputCorrect) this.print.displayWarn();
            this.print.displayMenu(this.identify);
            this.print.displayOption();
            this.optionString = inputOption();
            isInputCorrect = true;
            break;
        }
        while (!this.optionString.matches("^[0-9]*$") || (Integer.parseInt(this.optionString) > 9 || Integer.parseInt(this.optionString) < 1));

        executeSelect(optionString);
    }

    public static String inputOption() {
        Scanner in = new Scanner(System.in);
        String option = in.next();
        return option;
    }

    public void executeSelect(String optionString) {
        int selectOption = Integer.parseInt(optionString);
        if (this.identify == User.customer) {
            switch (selectOption) {
                case 1:
                    print.displayBooks(this.library.getAllBooks());
                    break;
                case 2:
                    print.displayInputBookSerail();
                    library.checkoutBook(inputOption(), libraryNumber);
                    break;
                case 3:
                    print.displayInputBookSerail();
                    library.returnBook(inputOption(), libraryNumber);
                    break;
                case 4:
                    print.displayMovies(this.library.getAllMovies());
                    break;
                case 5:
                    print.displayInputMovieSerail();
                    library.checkoutMovie(inputOption(), libraryNumber);
                case 6:
                    print.displayInputMovieSerail();
                    library.returnMovies(inputOption(), libraryNumber);
                    break;
                case 7:
                    print.diplayPerInfo(libraryNumber, library.users);
                case 8:
                    print.displayWelcomeMessage();
                    login();
                    start();
                case 9:
                    print.displayQuit();
                    break;
            }
        }
        if (this.identify == User.librarian) {
            switch (selectOption) {
                case 1:
                    print.displayCheckoutInfo(library.users);
                    break;
                case 2:
                    print.displayWelcomeMessage();
                    login();
                    start();
                    break;
                case 3:
                    print.displayQuit();
                    break;
            }
        }

        if ((this.identify == User.customer && selectOption != 9) || (this.identify == User.librarian && selectOption != 3)) {
            int continueOption = continueSelect();
            if (continueOption == 1) start();
            else if (continueOption == 2) print.displayQuit();
        }
    }

    public int continueSelect() {
        Boolean isInputCorrect = false;
        do {
            if (isInputCorrect) this.print.displayWarn();
            print.displayContinueOption();
            continueOptionString = inputOption();
            isInputCorrect = true;
        }
        while (!continueOptionString.matches("^[0-9]*$") || (Integer.parseInt(continueOptionString) > 2 || Integer.parseInt(continueOptionString) < 1));

        return Integer.parseInt(continueOptionString);
    }

    public int login() {
        Boolean isInputCorrect = false;

        do {
            if (isInputCorrect) print.displayLoginWrong();

            print.displayInputLibraryNumber();
            this.libraryNumber = inputOption();
            print.displayInputPassword();
            this.password = inputOption();

            for (User user : this.library.users) {
                if (this.libraryNumber.equals(user.getLibraryNumber()) && this.password.equals(user.getPassWord())) {
                    this.identify = user.getIdentify();
                    return user.getIdentify();
                }
            }

            isInputCorrect = true;
        } while (true);
    }
}
