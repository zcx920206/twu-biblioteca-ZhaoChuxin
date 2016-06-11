package com.twu.biblioteca;

import java.util.Map;

/**
 * Created by cxzhao on 6/8/16.
 */
public class View {
    public void displayWelcomeMessage() {
        System.out.println("*******************************");
        System.out.println("Welcome to  Biblioteca!");
        System.out.println("*******************************");
    }

    public void displayMenu() {
        System.out.println("1.List Books");
        System.out.println("2.Checkout Book");
        System.out.println("3.Return Book");
        System.out.println("4.Quit");
    }

    public void displayContinueOption() {
        System.out.println("*******************************");
        System.out.print("Do you want to continue? input 1.yes 2.no :");
    }

    public void displayWarn() {
        System.out.println("*******************************");
        System.out.println("Select a valid option!");
        System.out.println("*******************************");
    }

    public void displayBooks(Map<String, Book> allBooks) {
        System.out.println("THE LIST OF ALL AVALIBALE BOOKS:");
        int i = 0;
        for (Map.Entry<String, Book> entry : allBooks.entrySet()) {
            i++;
            System.out.println(i +".\nBookName:"+ entry.getValue().Name +"\nBookAuthor:"+ entry.getValue().author +"\nPublicYear:"+ entry.getValue().year+"\nSerail:"+entry.getKey());
        }
    }
    public void displayOption(){
        System.out.println("*******************************");
        System.out.print("Please input option:");
    }
    public void displayInputBookSerail(){
        System.out.println("*******************************");
        System.out.print("please input book's serail:");
    }
    public void displayQuit(){
        System.out.println("*******************************");
        System.out.println("Thanks for coming !");
    }
}








