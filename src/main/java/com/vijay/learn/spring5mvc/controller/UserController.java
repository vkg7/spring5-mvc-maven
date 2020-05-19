package com.vijay.learn.spring5mvc.controller;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5mvc.domain.Login;
import com.vijay.learn.spring5mvc.domain.User;
import com.vijay.learn.spring5mvc.exception.UserAlreadyExistsException;
import com.vijay.learn.spring5mvc.exception.UserNotFoundException;
import com.vijay.learn.spring5mvc.service.LoginService;
import com.vijay.learn.spring5mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final LoginService loginService;

    public UserController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    private User showRegistrationScreen() {
        User user = new User();
        user.setUserId("Please Enter Your User Id");
        user.setUserName("Please Enter Your User Name");
        user.setPassword("Please Enter Your Password");
        return user;
    }

    private User showLoginScreen() {
        User user = new User();
        user.setUserName("Please Enter Your User Name");
        user.setPassword("Please Enter Your Password");
        return user;
    }

    public String showLoginPage() {
        showLoginScreen();
        return "login";
    }

    public String showRegistrationPage() {
        showRegistrationScreen();
        return "register";
    }

    public User registerUser(User user) throws UserAlreadyExistsException {
        return this.userService.registerUser(user);
    }

    public Login login(Login login) throws Exception {
       return this.loginService.login(login);
    }

    public User updateUser(User user) {
        return this.userService.saveUser(user);
    }

    public User findUserById(Long id, Model model) {
        return this.userService.findUserById(id);
    }

    public List<User> getAllUsers(Model model) {
        return this.userService.getAllUsers();
    }
}
