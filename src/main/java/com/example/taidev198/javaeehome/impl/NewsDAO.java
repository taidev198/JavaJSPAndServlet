package com.example.taidev198.javaeehome.impl;

import com.example.taidev198.javaeehome.dao.AbstractDAO;
import com.example.taidev198.javaeehome.dao.INewsDAO;
import com.example.taidev198.javaeehome.mapper.NewsMapper;
import com.example.taidev198.javaeehome.model.NewsModel;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {


    @Override
    public NewsModel findOneById(Long id) {
        String sql = "select * from news where id = ?";
//        List<NewsModel> news = query(sql, new NewsMapper(), id);
//        return news.isEmpty() ? null : news.get(0);

        return null;
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "select * from news where category_id=?";
       // return query(sql, new NewsMapper(), categoryId);
        return null;
    }

    @Override
    public List<NewsModel> findAll() {
        String sql = "select * from news ";
       // return query(sql, new NewsMapper());
        return null;
    }

    @Override
    public Long save(NewsModel newsModel) {
        StringBuilder sql = new StringBuilder("insert into news(title,content, thumbnails,shortdescription,category_id,createddate,modifieddate,createdby,modifiedby) ");
        sql.append(" values(?,?,?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(),
                newsModel.getTitle(),
                newsModel.getContent(),
                newsModel.getThumbnails(),
                newsModel.getShortDescription(),
                newsModel.getCategoryId(),
                newsModel.getCreatedDate(),
                newsModel.getModifiedDate(),
                newsModel.getCreatedBy(),
                newsModel.getModifiedBy());

      //  return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from news where id=?";
        update(sql, id);
    }

    @Override
    public void update(NewsModel newsModel) {
        StringBuilder sql = new StringBuilder("update news set title =?,content =?, thumbnails = ?,shortdescription= ?,category_id =?,createddate=?,modifieddate=?,createdby=?,modifiedby=? ");
         update(sql.toString(),
                newsModel.getTitle(),
                newsModel.getContent(),
                newsModel.getThumbnails(),
                newsModel.getShortDescription(),
                newsModel.getCategoryId(),
                newsModel.getCreatedDate(),
                newsModel.getModifiedDate(),
                newsModel.getCreatedBy(),
                newsModel.getModifiedBy());
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        return List.of();
    }

    @Override
    public void update(String sql, Object... parameters) {

    }

    @Override
    public Long insert(String sql, Object... parameters) {
        return 0l;
    }

    @Override
    public void delete(String sql, Object... parameters) {

    }

    @Override
    public void count(String sql, Object... parameters) {

    }
}
