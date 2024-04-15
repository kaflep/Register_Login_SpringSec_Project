package com.example.webAppUserLogin.service;

import com.example.webAppUserLogin.model.UserDtls;

public interface UserService {
    public UserDtls createUser(UserDtls user);
    public boolean checkEmail(String email);
}
