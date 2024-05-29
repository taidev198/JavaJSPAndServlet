package com.example.taidev198.javaeehome.mapper;


import com.example.taidev198.javaeehome.model.RoleModel;
import com.example.taidev198.javaeehome.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {


    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            UserModel userModel = new UserModel();
            userModel.setId(rs.getLong("id"));
            userModel.setUserName(rs.getString("username"));
            userModel.setPassword(rs.getString("password"));
            userModel.setStatus(rs.getInt("status"));
            RoleModel roleModel = new RoleModel();
            roleModel.setCode(rs.getString("roleCode"));
            roleModel.setName(rs.getString("name"));
            userModel.setRole(roleModel);
            return userModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
