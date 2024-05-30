package com.example.taidev198.javaeehome.impl;

import com.example.taidev198.javaeehome.dao.AbstractDAO;
import com.example.taidev198.javaeehome.dao.ICategoryDAO;
import com.example.taidev198.javaeehome.mapper.CategoryMapper;
import com.example.taidev198.javaeehome.model.CategoryModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {



    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from category";
        return query(sql, new CategoryMapper());
    }
}
