package com.example.movieProject.Controller;

import com.example.movieProject.Entity.Movie;
import com.example.movieProject.Entity.User;
import com.example.movieProject.Service.MovieService;
import com.example.movieProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {return "Welcome to 'Movies For Later'";}

    @GetMapping("/user/all")
    public List<User> getAllUsers() {return this.userService.getAllUsers();}

    @GetMapping("/user")
    public User getUser(@RequestBody User user) { return this.userService.getUser(user);}

    @GetMapping("/user/{userEmail}")
    public User getUserById(@PathVariable String userEmail) { return this.userService.getUserByEmail(userEmail);}

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/user/{userEmail}")
    public String deleteUser(@PathVariable String userEmail) {
        return this.userService.deleteUser(userEmail);
    }

    @GetMapping("/user/movie/{userEmail}")
    public List<Movie> getMoviesForUser(@PathVariable String userEmail) {
        return this.movieService.getMoviesForUserId(userEmail);
    }

    @PostMapping("/user/movie")
    public Movie addMovieForUser(@RequestBody Movie movie) {
        return this.movieService.addMovieForUser(movie);
    }
}
