package com.vijay.learn.spring5mvc.client;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5mvc.controller.UserController;
import com.vijay.learn.spring5mvc.domain.User;
import com.vijay.learn.spring5mvc.exception.UserAlreadyExistsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class UserClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring5mvc/spring-application-context-spring5mvc.xml");
        UserController userController = applicationContext.getBean("userController", UserController.class);
        User user = new User();
        user.setUserId("test_id");
        user.setUserName("test_name");
        user.setPassword("test_password");
        user.setUserRole("test_role");
        user.setUserStatus("test_status");
        user.setDate(LocalDateTime.now());

        try {
            userController.registerUser(user);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
