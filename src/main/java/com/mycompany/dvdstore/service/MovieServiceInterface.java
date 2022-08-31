package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.stereotype.Service;

public interface MovieServiceInterface {
    void registerMovie(Movie movie);
}
