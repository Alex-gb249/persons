package com.alexis.persons.controllers;

import com.alexis.persons.models.UserModel;
import com.alexis.persons.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserModel> obtainUsers(){
        return this.userService.obtainUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> obtainUserById(@PathVariable("id") Long id){
        return this.userService.obtainById(id);
    }

    // Just an example to do something as query
    @GetMapping("/query")
    public List<UserModel> obtainUsersByPriority(@RequestParam("priority") Integer priority){
        return this.userService.obtainByPriority(priority);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean deleted = this.userService.deleteById(id);
        return deleted ? "Se eliminó el usuario " + id : "No se pudo eliminar el usuario " + id;
    }

}
