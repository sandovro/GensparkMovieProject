package com.example.movieProject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_id")
    private Integer listId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "movie_director")
    private String movieDir;

    public Movie() {
    }

    public Movie(Integer listId, String movieName, String userEmail, String movieDir) {
        this.listId = listId;
        this.movieName = movieName;
        this.userEmail = userEmail;
        this.movieDir = movieDir;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMovieDir() {
        return movieDir;
    }

    public void setMovieDir(String movieDir) {
        this.movieDir = movieDir;
    }
}