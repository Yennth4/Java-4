package com.sof3011.yennth4.Asm1.service;

import com.sof3011.yennth4.Asm1.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    
    List<Movie> listMovie = new ArrayList<>();

    public MovieService() {
        
        listMovie.add(new Movie("1" , "Ma" , "Kinh di" , true , "crWhQ-zyv0M" ));
        listMovie.add(new Movie("2" , "Ma1" , "Kinh di1" , false , "uv7q1Dlbhc4" ));
    }
    
    public List<Movie> getAllMovie() {
        return listMovie;
    }

    public void addMovie(Movie movie) {
        listMovie.add(movie);
    }

    public void deleteMovie (String id) {
        for(int i = 0; i < listMovie.size(); i++) {
            if (listMovie.get(i).getId().equalsIgnoreCase(id)) {
                listMovie.remove(i);
            }
        }
    }

    public Movie detailMovie(String id) {
        for(Movie movie : listMovie) {
            if (movie.getId().equalsIgnoreCase(id)) {
                return movie;
            }
        }
        return null;
    }

    public void updateMovie(Movie movie) {
        for (int i = 0; i < listMovie.size(); i++) {
            if (listMovie.get(i).getId().equalsIgnoreCase(movie.getId())){
                listMovie.set(i , movie);
            }
        }
    }
}
