package com.example.stocknew.controllers;

import com.example.stocknew.models.User;
import com.example.stocknew.models.UserDTO;
import com.example.stocknew.repos.UserRepository;
import com.example.stocknew.services.MyUserDetailsService;
import com.example.stocknew.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class HomeController {
    private final UserService userService;
    private final MyUserDetailsService myUserDetailsService;
    private final UserRepository userRepository;


    public HomeController(UserRepository userRepository, UserService userService, MyUserDetailsService myUserDetailsService, UserRepository userRepository1) {

        this.userService = userService;
        this.myUserDetailsService = myUserDetailsService;
        this.userRepository = userRepository1;
    }

    @GetMapping("/")
    public String landing(){
        return ("<h1>welcome Stranger</h1>");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username){
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        return ResponseEntity.ok(map);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> usersign(@Valid @RequestBody UserDTO userDTO){

        if (userService.exists(userDTO))
        {
            ResponseEntity.status(HttpStatus.CONFLICT).body("user already exists");
        }

        return ResponseEntity.ok(userService.addUser(userDTO));
    }
}
