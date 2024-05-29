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
            userModel.setUserName(rs.getString("ur.name"));
            userModel.setPassword(rs.getString("ur.password"));
            userModel.setStatus(rs.getInt("ur.status"));
            try {
                RoleModel roleModel = new RoleModel();
                roleModel.setCode(rs.getString("ro.code"));
                roleModel.setName(rs.getString("ro.name"));
                userModel.setRole(roleModel);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            return userModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
