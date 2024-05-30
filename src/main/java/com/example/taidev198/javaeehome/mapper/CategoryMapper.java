package com.example.taidev198.javaeehome.mapper;

import com.example.taidev198.javaeehome.model.CategoryModel;
import com.example.taidev198.javaeehome.model.NewsModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {


    @Override
    public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(rs.getLong("id"));
            categoryModel.setName(rs.getString("name"));
            categoryModel.setCode(rs.getString("code"));
            categoryModel.setModifiedBy(rs.getString("modifiedby"));
            categoryModel.setCreatedBy(rs.getString("createdby"));
            if (rs.getTimestamp("modifieddate") != null) {
                categoryModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if (rs.getTimestamp("createddate") != null)
                categoryModel.setCreatedDate(rs.getTimestamp("createddate"));
            return categoryModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
