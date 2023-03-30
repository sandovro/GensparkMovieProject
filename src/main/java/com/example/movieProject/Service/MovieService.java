package com.example.movieProject.Service;

import com.example.movieProject.Dao.IMovieDao;
import com.example.movieProject.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private IMovieDao movieDao;


    public MovieService(IMovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie addMovieForUser(Movie movie) {
        return this.movieDao.save(movie);
    }

    @Override
    public List<Movie> getMoviesForUserId(String userEmail) {
        List<Movie> movies = this.movieDao.findAll();
        List<Movie> userMovies = new ArrayList<>();

        for(var v:movies) {
            if(v.getUserEmail().equals(userEmail))
                userMovies.add(v);
        }

        return userMovies;
    }
}
