package com.example.taidev198.javaeehome.dao;

import com.example.taidev198.javaeehome.model.NewsModel;

import java.util.List;

public interface INewsDAO extends GenericDAO<NewsModel> {
    NewsModel findOneById(Long id);
    List<NewsModel> findByCategoryId(Long categoryId);
    List<NewsModel> findAll(Integer offset, Integer limit);
    Long save(NewsModel newsModel);
    void delete(Long id);
    void update(NewsModel newsModel);
    int getTotalItems();
}
