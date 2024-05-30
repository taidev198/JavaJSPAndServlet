package com.example.taidev198.javaeehome.service;

import com.example.taidev198.javaeehome.dao.ICategoryDAO;
import com.example.taidev198.javaeehome.impl.CategoryDAO;
import com.example.taidev198.javaeehome.model.CategoryModel;

import java.util.List;

public class CategoryService implements ICategoryService {

    private ICategoryDAO categoryDAO = new CategoryDAO();;

    @Override
    public List<CategoryModel> findAllCategory() {
        return categoryDAO.findAll();
    }
}
