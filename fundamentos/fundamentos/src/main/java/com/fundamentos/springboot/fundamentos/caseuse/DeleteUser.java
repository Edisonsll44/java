package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService _userService;

    public  DeleteUser(UserService userService){
        _userService = userService;
    }
    public void Remove(Long id) {
        _userService.Remove(id);
    }
}
