package com.vijay.learn.spring5mvc.service;
/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5mvc.domain.Login;
import com.vijay.learn.spring5mvc.exception.UserNotFoundException;

public interface LoginService {
    Login login(Login login) throws Exception;
}
