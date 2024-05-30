package springboot.usermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.usermanagement.model.User;
import springboot.usermanagement.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired private UserServiceImpl userService;

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @GetMapping()
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping()
    public User updateUserData(@RequestBody User user){
        return userService.updateUserData(user);
    }
}
