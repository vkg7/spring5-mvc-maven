package com.vijay.learn.spring5mvc.controller;
/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5mvc.domain.Login;
import com.vijay.learn.spring5mvc.exception.UserNotFoundException;
import com.vijay.learn.spring5mvc.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import javax.validation.Valid;

@Controller
public class LoginController extends SimpleControllerHandlerAdapter{

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ModelAttribute("login")
    public Login showLoginScreen() {
        Login login = new Login();
       /* login.setUsername("Please Enter Your User Name");
        login.setPassword("Please Enter Your Password");*/
        return login;
    }

    @GetMapping("/")
    public String showLoginPage() {
        showLoginScreen();
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model) throws Exception {
        System.out.println("LoginController.login - login = " + login.toString());
        if (bindingResult.hasErrors()) {
            System.err.println("LoginController.login - bindingResult = " + bindingResult.getAllErrors().toString());
            //showLoginScreen();
            return "login";
        }
        Login loginUser = this.loginService.login(login);
        if (loginUser != null) {
            model.addAttribute("message", "Welcome " + loginUser.getUsername());
            return "redirect:/users";// redirect the url
        }

        model.addAttribute("message", "Username or Password is wrong!!");
        System.err.println("LoginController.login - Username or Password is wrong!!");
        return "login";
    }
}
