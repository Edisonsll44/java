package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements  IGetUser{
   private UserService _userService;

   public GetUserImplement(UserService userService){
       _userService = userService;
   }
    @Override
    public List<User> getAllUsers() {
        return _userService.getAllUsers();
    }
}
