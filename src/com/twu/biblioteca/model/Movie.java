package com.twu.biblioteca.model;

/**
 * Created by cxzhao on 6/11/16.
 */
public class Movie {
    private String name;
    private int year;
    private String director;
    private String movieRation;

    public String getMovieRation() {
        return movieRation;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void setInfo(String name, int year, String director, String movieRation) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRation = movieRation;
    }
}
