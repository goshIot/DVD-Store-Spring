package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.service.DefaultMovieService;

public class App
{
    public static void main( String[] args )
    {
        DefaultMovieService defaultMovieService = new DefaultMovieService();
        defaultMovieService.setMovieRepository(new FileMovieRepository());

        MovieController movieController = new MovieController();
        movieController.setMovieService(defaultMovieService);
        movieController.addUsingConsole();
    }
}
