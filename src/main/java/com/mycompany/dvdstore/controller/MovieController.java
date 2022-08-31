package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class MovieController {

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @Autowired
    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private MovieServiceInterface movieService;


    public void addUsingConsole(){
        System.out.println( "Enter movie title and genre!" );
        Scanner sc = new Scanner(System.in);
        Movie movie = new Movie(sc.nextLine(), sc.nextLine());
        movieService.registerMovie(movie);
    }
}
