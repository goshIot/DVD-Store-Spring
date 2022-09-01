package com.mycompany.dvdstore.repository.file;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

    @Value("${movies.file.location}")
    public void setFile(String str) {
        this.file = new File(str);
    }

    private File file;

    public void add(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(file,true);
            writer.write(movie.getTitle() + ";" + movie.getGenre() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> list() {
        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\;");
                movie.setTitle(titreEtGenre[0]);
                movie.setGenre(titreEtGenre[1]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;    }
}
