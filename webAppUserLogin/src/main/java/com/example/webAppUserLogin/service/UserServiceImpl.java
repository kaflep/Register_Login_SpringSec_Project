package com.example.webAppUserLogin.service;

import com.example.webAppUserLogin.model.UserDtls;
import com.example.webAppUserLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public BCryptPasswordEncoder passwordEncoder;
//    @Override
//    public UserDtls createUser(UserDtls user) {
//
//        return  userRepository.save(user);
//    }
        @Override
    public UserDtls createUser(UserDtls user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");

        return  userRepository.save(user);
    }

    @Override
    public boolean checkEmail(String email) {

        return userRepository.existsByEmail(email);
    }
}
