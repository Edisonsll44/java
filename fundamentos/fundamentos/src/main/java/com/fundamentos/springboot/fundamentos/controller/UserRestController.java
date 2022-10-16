package com.fundamentos.springboot.fundamentos.controller;

import com.fundamentos.springboot.fundamentos.caseuse.CreateUser;
import com.fundamentos.springboot.fundamentos.caseuse.DeleteUser;
import com.fundamentos.springboot.fundamentos.caseuse.IGetUser;
import com.fundamentos.springboot.fundamentos.caseuse.UpdateUser;
import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private IGetUser _getUser;
    private CreateUser _createUser;
    private DeleteUser _deleteUser;
    private UpdateUser _updateUser;
    public UserRestController(IGetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser){
        _getUser = getUser;
        _createUser = createUser;
        _deleteUser = deleteUser;
        _updateUser = updateUser;
    }

    @GetMapping("/")
    List<User> Get(){
        return _getUser.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<User> NewUser(@RequestBody User newUser){
        return  new ResponseEntity<>(_createUser.Save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void DeleteUser(@PathVariable Long id){
        _deleteUser.Remove(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> ReplaceUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>( _updateUser.Update(newUser, id), HttpStatus.OK);
    }
}
