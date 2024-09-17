package com.lovice.controller;

import com.lovice.model.User;
import com.lovice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth") // all the endpoint from this controller will start from /auth
public class AuthController {

    @Autowired //automatically inject the dependencies required by a class
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user){ // we are getting the user from request body
        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser = userRepository.save(newUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}

