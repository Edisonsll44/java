package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
private UserService _userService;

    public CreateUser(UserService userService){
        _userService = userService;
    }

    public User Save(User newUser) {
        return _userService.Save(newUser);
    }
}
