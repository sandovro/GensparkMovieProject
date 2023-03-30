package com.example.movieProject.Service;

import com.example.movieProject.Dao.IMovieDao;
import com.example.movieProject.Dao.IUserDao;
import com.example.movieProject.Entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
    @Mock
    private IMovieDao movieDao = mock(IMovieDao.class);
    @Mock
    private IUserDao userDao = mock(IUserDao.class);

    @Test
    void getAllUsers() {
        // Arrange
        List<User> expectedList = new ArrayList<>();
        User newUser = new User("alex@email.com","102030");
        UserService userService = new UserService(userDao,movieDao);
        expectedList.add(newUser);
        when(userDao.findAll()).thenReturn(expectedList);

        // Act
        List<User> actualList= userService.getAllUsers();

        // Assert
        assertEquals(expectedList,actualList);
    }

    @Test
    void getUser() {
        // Arrange
        String userId = "alex@email.com";
        User expectedUser = new User(userId,"102030");
        UserService userService = new UserService(userDao,movieDao);
        when(userDao.findById(userId)).thenReturn(Optional.of(expectedUser));

        // Act
        User actualUser = userService.getUser(expectedUser);

        // Assert
        assertEquals(expectedUser,actualUser);
    }

    @Test
    void getUserByEmail() {
        // Arrange
        String userId = "alex@email.com";
        User expectedUser = new User(userId,"102030");
        UserService userService = new UserService(userDao,movieDao);
        when(userDao.findById(userId)).thenReturn(Optional.of(expectedUser));

        // Act
        User actualUser = userService.getUserByEmail(userId);

        // Assert
        assertEquals(expectedUser,actualUser);
    }

    @Test
    void addUser() {
        // Arrange
        String userId = "alex@email.com";
        User expectedUser = new User(userId,"102030");
        UserService userService = new UserService(userDao,movieDao);

        when(userDao.save(expectedUser)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.addUser(expectedUser);

        // Assert
        assertEquals(expectedUser,actualUser);
    }

    @Test
    void updateUser() {
        // Arrange
        String userId = "alex@email.com";
        User expectedUser = new User(userId,"102030");
        UserService userService = new UserService(userDao,movieDao);

        when(userDao.save(expectedUser)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.updateUser(expectedUser);

        // Assert
        assertEquals(expectedUser,actualUser);
    }

    @Test
    void deleteUser() {
        // Arrange
        String expectedOutput = "User successfully deleted";
        String userId = "alex@email.com";
        User newUser = new User(userId,"102030");
        UserService userService = new UserService(userDao,movieDao);

        // Act
        String actualOuput = userService.deleteUser(userId);

        // Assert
        assertEquals(expectedOutput,actualOuput);
    }
}