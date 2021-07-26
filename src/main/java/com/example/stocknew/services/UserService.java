package com.example.stocknew.services;

import com.example.stocknew.models.User;
import com.example.stocknew.models.UserDTO;
import com.example.stocknew.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean exists(UserDTO userDTO){
       if (userRepository.existsByUserName(userDTO.getUserName()).isPresent()||
                userRepository.existsByEmailId(userDTO.getEmailId()).isPresent() ||
                userRepository.existsByMobile(userDTO.getMobile()).isPresent() )
           return true;
       return false;
    }
     public User addUser(UserDTO userDTO)
     {
         User user = new User();
         user.setUserName(userDTO.getUserName());
         user.setAdmin(false);
         user.setEmailId(userDTO.getEmailId());
         user.setPassword(userDTO.getPassword());
         user.setMobile(userDTO.getMobile());
          return userRepository.save(user);
     }
}
