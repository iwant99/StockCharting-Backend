package com.example.stocknew.services;

import com.example.stocknew.models.MyUserDetails;
import com.example.stocknew.models.User;
import com.example.stocknew.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=userRepository.findUserByUserName(userName);
        if (user == null)
        {
            throw new UsernameNotFoundException("username not found " + userName);
        }

        return new MyUserDetails(user);

    }

}
