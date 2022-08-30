package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        MovieService movieService = new MovieService();
        movieService.setMovieRepository(new GoLiveMovieRepository());

        MovieController movieController = new MovieController();
        movieController.setMovieService(movieService);
        movieController.addUsingConsole();
    }
}
