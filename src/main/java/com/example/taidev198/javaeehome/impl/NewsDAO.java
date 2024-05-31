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
        List<NewsModel> news = query(sql, new NewsMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "select * from news where category_id=?";
        return query(sql, new NewsMapper(), categoryId);
    }

    @Override
    public List<NewsModel> findAll(Integer offset, Integer limit) {
        StringBuilder sql = new StringBuilder("select * from news");
        if (offset !=null && limit != null) {
            sql.append(" LIMIT ?,? ;");
            System.out.println(sql.toString());
            return query(sql.toString(), new NewsMapper(), offset, limit);
        }
        System.out.println(sql.toString());
        return query(sql.toString(), new NewsMapper());
    }

    @Override
    public Long save(NewsModel newsModel, String params, String values, List<Object> paramsList) {
        //title,content, thumbnails,shortdescription,categoryid,createddate,modifieddate,createdby,modifiedby
        //?,?,?, ?, ?, ?, ?, ?, ?
        return insert("insert into news( " + params + ") " + " values( " + values + " )",
                paramsList.toArray(new Object[0]));
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from news where id=?";
        update(sql, id);
    }

    @Override
    public void update(NewsModel newsModel) {
        StringBuilder sql = new StringBuilder("update news set title =?,content =?,categoryid =?,createddate=?,modifieddate=?,createdby=?,modifiedby=? where id =?; ");
         update(sql.toString(),
                newsModel.getTitle(),
                newsModel.getContent(),
                newsModel.getCategoryId(),
                newsModel.getCreatedDate(),
                newsModel.getModifiedDate(),
                newsModel.getCreatedBy(),
                newsModel.getModifiedBy(),
                 newsModel.getId());
    }

    @Override
    public int getTotalItems() {

        String sql = "select count(*) from news";
        return count(sql);
    }
}
