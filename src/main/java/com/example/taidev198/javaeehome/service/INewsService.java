package com.example.taidev198.javaeehome.service;

import com.example.taidev198.javaeehome.model.NewsModel;
import com.example.taidev198.javaeehome.model.UserModel;

import java.util.List;

public interface INewsService {

    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel newsModel, UserModel userModel);
    void delete(Long[] ids);
    List<NewsModel> findAll(Integer offset, Integer limit);
    int getTotalItems();
    NewsModel findOneById(Long id);
}
