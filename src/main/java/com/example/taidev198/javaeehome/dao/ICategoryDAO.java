package com.example.taidev198.javaeehome.dao;

import com.example.taidev198.javaeehome.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
}
