package com.hkr.backend.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hkr.backend.model.Blog;

import org.springframework.jdbc.core.RowMapper;

public class BlogRowMapper implements RowMapper<Blog> {

    @Override
    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Blog(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("content"),
            rs.getDate("created_at")
        );
    }
    
}
