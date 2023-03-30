package com.example.movieProject.Service;

import com.example.movieProject.Entity.Movie;

import java.util.List;

public interface IMovieService {
    Movie addMovieForUser(Movie movie);
    List<Movie> getMoviesForUserId(String userEmail);
}
