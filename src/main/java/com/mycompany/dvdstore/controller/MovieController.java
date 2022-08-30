package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;

import java.util.Scanner;

public class MovieController {

    private MovieServiceInterface movieService;


    public void addUsingConsole(){
        System.out.println( "Enter movie title and genre!" );
        Scanner sc = new Scanner(System.in);
        Movie movie = new Movie(sc.nextLine(), sc.nextLine());
        movieService.registerMovie(movie);
    }
}
