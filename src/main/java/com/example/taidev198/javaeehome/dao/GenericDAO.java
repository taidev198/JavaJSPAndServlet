package com.example.taidev198.javaeehome.dao;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...parameters);
    void update(String sql, Object... parameters);
    Long insert(String sql, Object... parameters);
    void delete(String sql, Object... parameters);
    int count(String sql, Object... parameters);

}
