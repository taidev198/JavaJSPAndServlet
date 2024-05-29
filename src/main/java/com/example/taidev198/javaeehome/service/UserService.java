package com.example.taidev198.javaeehome.service;

import com.example.taidev198.javaeehome.dao.IUserDAO;
import com.example.taidev198.javaeehome.impl.UserDAO;
import com.example.taidev198.javaeehome.model.UserModel;

public class UserService implements IUserService {

    private IUserDAO userDAO = new UserDAO();

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
        return userDAO.findByUsernameAndPasswordAndStatus(username, password, status);
    }
}
