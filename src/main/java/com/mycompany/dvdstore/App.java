package com.mycompany.dvdstore;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Enter movie title and genre!" );
        Scanner sc = new Scanner(System.in);
        Movie movie = new Movie(sc.nextLine(), sc.nextLine());
        MovieService movieService = new MovieService();
        movieService.registerMovie(movie);
    }
}
