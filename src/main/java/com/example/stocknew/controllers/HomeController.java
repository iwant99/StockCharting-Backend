package com.example.stocknew.controllers;

import com.example.stocknew.models.User;
import com.example.stocknew.models.UserDTO;
import com.example.stocknew.repos.UserRepository;
import com.example.stocknew.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class HomeController {
    private final UserService userService;

    public HomeController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String landing(){
        return ("<h1>welcome Stranger</h1>");
    }

    @PostMapping("/signup")
    public ResponseEntity<User> usersign(@Valid @RequestBody UserDTO userDTO){

        if (userService.exists(userDTO))
        {
            ResponseEntity.status(HttpStatus.CONFLICT).body("company id doesnt exists");
        }

        return ResponseEntity.ok(userService.addUser(userDTO));

    }
    {

    }
}
