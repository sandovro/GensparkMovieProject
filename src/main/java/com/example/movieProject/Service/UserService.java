package com.example.movieProject.Service;

import com.example.movieProject.Dao.IMovieDao;
import com.example.movieProject.Dao.IUserDao;
import com.example.movieProject.Entity.Movie;
import com.example.movieProject.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserDao userDao;

    @Autowired
    private IMovieDao movieDao;

    public UserService(IUserDao userDao, IMovieDao movieDao) {
        this.userDao = userDao;
        this.movieDao = movieDao;
    }

    @Override
    public List<User> getAllUsers(){
        return this.userDao.findAll();
    }

    @Override
    public User getUser(User user) {
        Optional<User> u = this.userDao.findById(user.getUserEmail());
        if(u.isPresent()){
            if(u.get().getUserPass().equals(user.getUserPass()))
                return u.get();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        User user = null;
        Optional<User> u = this.userDao.findById(userEmail);
        if(u.isPresent())
            user = u.get();
        else
            throw new RuntimeException("User with ID: "+userEmail+" was not found");
        return user;
    }



    @Override
    public User addUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public String deleteUser(String userEmail) {
        List<Movie> movieList = this.movieDao.findAll();
        for(var m:movieList){
            if(m.getUserEmail().equals(userEmail))
                this.movieDao.deleteById(m.getListId());
        }
        this.userDao.deleteById(userEmail);
        return "User successfully deleted";
    }
}
