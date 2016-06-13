package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxzhao on 6/11/16.
 */
public class User {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String passWord;
    private String libraryNumber;
    private int identify;
    public static int customer = 2;
    public static int librarian = 1;
    private List<String> checkoutBookName = new ArrayList<>();
    private List<String> checkoutMovieName = new ArrayList<>();

    public List<String> getCheckoutBookName() {
        return checkoutBookName;
    }

    public void setCheckoutBookName(List<String> checkoutBookName) {
        this.checkoutBookName = checkoutBookName;
    }

    public List<String> getCheckoutMovieName() {
        return checkoutMovieName;
    }

    public void setCheckoutMovieName(List<String> checkoutMovieName) {
        this.checkoutMovieName = checkoutMovieName;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }


    public User(String name, String emailAddress, String phoneNumber, String libraryNumber, String password, int identify) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.passWord = password;
        this.identify = identify;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }
}
