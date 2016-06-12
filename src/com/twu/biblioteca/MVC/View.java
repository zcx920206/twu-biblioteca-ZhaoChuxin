package com.twu.biblioteca.MVC;

import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Movie;
import com.twu.biblioteca.others.User;

import java.util.List;
import java.util.Map;

/**
 * Created by cxzhao on 6/8/16.
 */
public class View {
    public void displayWelcomeMessage() {
        System.out.println("*******************************");
        System.out.println("Welcome to  Biblioteca!");
        System.out.println("Please Login");

    }
    public void displayInputLibraryNumber(){
        System.out.println("*******************************");
        System.out.println("Library Number:");
    }
    public void displayInputPassword(){
        System.out.println("Password");
    }


    public void displayMenu(int indentify) {
        if(indentify==2){
            System.out.println("1.List Books");
            System.out.println("2.Check out Book");
            System.out.println("3.Return Book");
            System.out.println("4.List Movies");
            System.out.println("5.Checkout Movie");
            System.out.println("6.Return Movie");
            System.out.println("7.Person Information");
            System.out.println("8.Logout");
            System.out.println("9.Quit");
        }
        else if(indentify==1)
        {
            System.out.println("1.List Checked out Books");
            System.out.println("2.Logout");
            System.out.println("3.Quit");
        }
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
            System.out.println(i +".\nBookName:"+ entry.getValue().getName() +"\nBookAuthor:"+ entry.getValue().getAuthor() +"\nPublicYear:"+ entry.getValue().getYear()+"\nSerail:"+entry.getKey());
        }
    }
    public void displayMovies(Map<String,Movie>allMovies){
        System.out.println("THE LIST OF ALL AVALIBALE Movies:");
        int i = 0;
        for (Map.Entry<String, Movie> entry : allMovies.entrySet()) {
            i++;
            System.out.println(i +".\nMovieName:"+ entry.getValue().getName() +"\nDirector:"+ entry.getValue().getDirector() +"\nPublicYear:"+ entry.getValue().getYear()+"\nMovieRate:"+entry.getValue().getMovieRation()+"\nSerail:"+entry.getKey());
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
    public void displayInputMovieSerail(){
        System.out.println("*******************************");
        System.out.print("please input movie's serail:");
    }
    public void diplayPerInfo(String libraryNumber, List<User> users){
        for (User user:users) {
            if(libraryNumber.equals(user.getLibraryNumber()))
            System.out.println("Name:"+user.getName()+"Email:"+user.getEmailAddress()+"PhoneNumber:"+user.getPhoneNumber());
            break;
        }

    }
    public  void displayCheckoutInfo(List<User>users){
        for (User user:users) {
           if(user.getCheckoutBookName().size()>0) {
               for (String bookName:user.getCheckoutBookName())
               System.out.println("User:"+user.getName()+",BookName:"+bookName);
           }
            if (user.getCheckoutMovieName().size()>0){
                for (String movieName:user.getCheckoutBookName())
                    System.out.println("User:"+user.getName()+",movieName:"+movieName);
            }
        }
    }
    public void displayQuit(){
        System.out.println("*******************************");
        System.out.println("Thanks for coming !");
    }
}








