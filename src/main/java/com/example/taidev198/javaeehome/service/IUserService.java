package com.example.taidev198.javaeehome.service;

import com.example.taidev198.javaeehome.model.UserModel;

public interface IUserService {

    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
