package com.example.taidev198.javaeehome.impl;

import com.example.taidev198.javaeehome.dao.AbstractDAO;
import com.example.taidev198.javaeehome.dao.IUserDAO;
import com.example.taidev198.javaeehome.mapper.UserMapper;
import com.example.taidev198.javaeehome.model.UserModel;


import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {


    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
        StringBuilder sql = new StringBuilder("select * from user as ur ");

        sql.append(" INNER JOIN role as ro ON ro.id == ur.roleid ");
        sql.append("where username = ? and password = ? and status = ? ;");
        List<UserModel> userModels = query(sql.toString(), new UserMapper(), username, password, status);
        return userModels.isEmpty() ? null : userModels.get(0);
    }
}
