package com.crud.fullstack.backend.controller;

import com.crud.fullstack.backend.exception.UserNotFoundException;
import com.crud.fullstack.backend.model.User;
import com.crud.fullstack.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3001")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public String user(@RequestBody User user){
        userRepository.save(user);
        return "recored saved";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){

        if (!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "record deleted";

    }
}
