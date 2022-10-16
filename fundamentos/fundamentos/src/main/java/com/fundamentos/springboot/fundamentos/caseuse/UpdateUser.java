package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService _userService;

    public UpdateUser(UserService userService)
    {
        _userService = userService;
    }
    public User Update(User newUser, Long id) {
        return _userService.Update(newUser, id);
    }
}
