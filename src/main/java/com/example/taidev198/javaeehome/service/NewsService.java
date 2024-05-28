package com.example.taidev198.javaeehome.service;

import com.example.taidev198.javaeehome.impl.NewsDAO;
import com.example.taidev198.javaeehome.model.NewsModel;
import jakarta.inject.Inject;

import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService{

    @Inject
    private NewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        Long id = newsDAO.save(newsModel);
        return newsDAO.findOneById(id);
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        NewsModel oldNews = newsDAO.findOneById(newsModel.getId());
        newsModel.setCreatedDate(oldNews.getCreatedDate());
        newsModel.setCreatedBy(oldNews.getCreatedBy());
        newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setModifiedBy("");
        newsDAO.update(newsModel);
        return newsDAO.findOneById(newsModel.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            newsDAO.delete(id);
        }
    }

    @Override
    public List<NewsModel> findAll() {
        return newsDAO.findAll();
    }
}
