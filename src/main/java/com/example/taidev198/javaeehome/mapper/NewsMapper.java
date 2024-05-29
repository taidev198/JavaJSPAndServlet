package com.example.taidev198.javaeehome.mapper;

import com.example.taidev198.javaeehome.model.NewsModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class NewsMapper implements RowMapper<NewsModel> {


    @Override
    public NewsModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        try {
            NewsModel newsModel = new NewsModel();
            newsModel.setId(rs.getLong("id"));
            newsModel.setTitle(rs.getString("title"));
            newsModel.setContent(rs.getString("content"));
            newsModel.setCategoryId(rs.getLong("categoryid"));
            newsModel.setThumbnails(rs.getString("thumbnails"));
            newsModel.setShortDescription(rs.getString("shortdescription"));

            newsModel.setModifiedBy(rs.getString("modifiedby"));
            if (rs.getTimestamp("modifieddate") != null) {
                newsModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if (rs.getTimestamp("createddate") != null)
                newsModel.setCreatedDate(rs.getTimestamp("createddate"));
            return newsModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
