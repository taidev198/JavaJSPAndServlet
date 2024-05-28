package com.example.taidev198.javaeehome.service;

import com.example.taidev198.javaeehome.model.NewsModel;

import java.util.List;

public interface INewsService {

    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel newsModel);
    void delete(Long[] ids);
    List<NewsModel> findAll();
}
