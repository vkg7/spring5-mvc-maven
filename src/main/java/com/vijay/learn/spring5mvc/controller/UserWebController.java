package com.vijay.learn.spring5mvc.controller;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5mvc.domain.User;
import com.vijay.learn.spring5mvc.exception.UserAlreadyExistsException;
import com.vijay.learn.spring5mvc.exception.UserNotFoundException;
import com.vijay.learn.spring5mvc.service.LoginServiceImpl;
import com.vijay.learn.spring5mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserWebController {

    private static final Logger logger = LoggerFactory.getLogger(UserWebController.class);

    private final UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User showRegistrationScreen() {
        User user = new User();
       /* user.setUserId("Please Enter Your User Id");
        user.setUserName("Please Enter Your User Name");
        user.setPassword("Please Enter Your Password");*/
        return user;
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        showRegistrationScreen();
        return "register";
    }

    @PostMapping("/registerUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws UserAlreadyExistsException {
        System.out.println("UserWebController.saveUser - user = " + user.toString());
        if (bindingResult.hasErrors()) {
            System.err.println("UserWebController.saveUser -  bindingResult = " + bindingResult.getAllErrors().toString());
            //showRegistrationScreen();
            return "register";
        }
        this.userService.registerUser(user);
        return "redirect:/users";// redirect the url
        //dont use the redirecr: forwarded and the url will not change
    }

    /*@PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        System.out.println("user = " + user.toString() + ", bindingResult = " + bindingResult.toString());
        if(bindingResult.hasErrors()){
            return "login";
        }
        User loginUser = this.userService.login(user.getUserId(), user.getPassword());
        if(loginUser != null) {
            model.addAttribute("message","Welcome "+loginUser.getUserName());
            return "redirect:/users";// redirect the url
        }

        model.addAttribute("message","Username or Password is wrong!!");
        return "login";
    }*/

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> listOfUsers = this.userService.getAllUsers();
        model.addAttribute("listOfUsers", listOfUsers);
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) throws UserNotFoundException {
        this.userService.delete(id);
        return "redirect:/users";// redirect the url
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws UserAlreadyExistsException, UserNotFoundException {
        System.out.println("UserWebController.updateUser - user = "+user.toString());
        /*if (bindingResult.hasErrors()) {
            System.err.println("UserWebController.updateUser -  bindingResult = " + bindingResult.getAllErrors().toString());
            //showRegistrationScreen();
            return "update";
        }*/
        this.userService.updateUser(user);
        return "redirect:/users";// redirect the url
    }
}
