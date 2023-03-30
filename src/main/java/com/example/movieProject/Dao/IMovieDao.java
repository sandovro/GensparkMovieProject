package com.example.movieProject.Dao;

import com.example.movieProject.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieDao extends JpaRepository<Movie,Integer> {
}
