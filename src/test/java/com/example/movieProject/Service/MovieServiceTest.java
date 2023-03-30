package com.example.movieProject.Service;

import com.example.movieProject.Dao.IMovieDao;
import com.example.movieProject.Entity.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {
    @Mock
    IMovieDao movieDao = mock(IMovieDao.class);

    @Test
    void addMovieForUser() {
        // Arrange
        Movie expectedMovie = new Movie(12, "Star Wars","alex@email.com","Disney");
        MovieService movieService = new MovieService(movieDao);

        when(movieDao.save(expectedMovie)).thenReturn(expectedMovie);
        
        // Act
        Movie actualMovie = movieService.addMovieForUser(expectedMovie);
        
        // Assert
        assertEquals(expectedMovie,actualMovie);
    }

    @Test
    void getMoviesForUserId() {
        // Arrange
        String userId = "alex@email.com";
        List<Movie> expectedList = new ArrayList<>();
        Movie newMovie = new Movie(12, "Star Wars","alex@email.com","Disney");
        expectedList.add(newMovie);

        MovieService movieService = new MovieService(movieDao);

        when(movieDao.findAll()).thenReturn(expectedList);

        // Act
        List<Movie> actualList = movieService.getMoviesForUserId(userId);

        // Assert
        assertEquals(expectedList,actualList);
    }
}