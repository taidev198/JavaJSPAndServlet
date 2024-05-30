package com.example.taidev198.javaeehome.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsModel extends AbstractModel<NewsModel>{

    private Long id;
    private String title;
    private String content;
    private String thumbnails;
    private String shortDescription;
    private Long categoryId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long[] getIds() throws SQLException {
        Long[] ids = new Long[getListModels().size()];
        for (int i = 0; i < getListModels().size(); i++) {
            ids[i] = (getListModels().get(i).getId());
        }
        return ids;
    }

}
