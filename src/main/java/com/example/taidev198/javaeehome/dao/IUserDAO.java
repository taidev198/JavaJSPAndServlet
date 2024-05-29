package com.example.taidev198.javaeehome.dao;

import com.example.taidev198.javaeehome.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {

    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);

}
