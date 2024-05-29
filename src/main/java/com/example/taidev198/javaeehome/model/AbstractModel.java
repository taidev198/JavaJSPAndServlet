package com.example.taidev198.javaeehome.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<T> {
    private Timestamp createdDate;
    private Timestamp modifiedDate ;
    private String createdBy ;
    private String modifiedBy;
    private List<T> listModels =  new ArrayList<>();
    private int page ;
    private int maxPageItem ;
    private int totalPages;
    private int totalItems ;

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<T> getListModels() {
        return listModels;
    }
    public void setListModels(List<T> listModels) {
        this.listModels = listModels;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPageItem() {
        return maxPageItem;
    }

    public void setMaxPageItem(int maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
