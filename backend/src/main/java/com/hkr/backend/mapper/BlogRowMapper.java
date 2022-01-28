package com.hkr.backend.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hkr.backend.model.Blog;
import com.hkr.backend.model.Comment;

import org.springframework.jdbc.core.RowMapper;

public class BlogRowMapper implements RowMapper<Blog> {

    @Override
    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blog blog = new Blog();
        blog.setId(rs.getLong("b_id"));
        blog.setTitle(rs.getString("b_title"));
        blog.setContent(rs.getString("b_content"));
        blog.setCreated_at(rs.getDate("b_created_at"));
        ArrayList<Comment> comments = new ArrayList<Comment>();

        // while (rs.next()) {
        //     Comment comment = new Comment();
        //     comment.setId(rs.getLong("c_id"));
        //     comment.setBlogid(rs.getLong("c_blogid"));
        //     comment.setCreated_at(rs.getDate("c_created_at"));
        //     comment.setText(rs.getString("c_text"));
        //     if (blog.getId() == comment.getBlogid()) {
        //         comments.add(comment);
        //     }
        // }
        System.out.println(String.format("RowNum : %d         BlogID : %d         CommentID : %d", rowNum ,rs.getLong("b_id"), rs.getLong("c_id")));
        blog.setComments(comments);
        return blog;
    }

}

// final class BlogResultSetExtractor implements ResultSetExtractor<Blog> {

// @Override
// public Blog extractData(ResultSet rs) throws SQLException,
// DataAccessException {
// Blog blog = new Blog();
// ArrayList<Comment> comments = blog.getComments();
// blog.setId(rs.getLong("b_id"));
// blog.setTitle(rs.getString("b_title"));
// blog.setContent(rs.getString("b_content"));
// blog.setCreated_at(rs.getDate("b_created_at"));
// if (comments == null) {
// comments = new ArrayList<Comment>();
// }
// Comment comment = new Comment(rs.getLong("c_id"), rs.getString("c_text"),
// rs.getLong("c_blogid"),
// rs.getDate("c_created_at"));
// comments.add(comment);
// blog.setComments(comments);
// // blog.setId(rs.getLong("b_id"));
// // blog.setTitle(rs.getString("b_title"));
// // blog.setContent(rs.getString("b_content"));
// // blog.setCreated_at(rs.getDate("b_created_at"));

// // while (rs.next()) {
// // blog.setId(rs.getLong("b_id"));
// // blog.setTitle(rs.getString("b_title"));
// // blog.setContent(rs.getString("b_content"));
// // blog.setCreated_at(rs.getDate("b_created_at"));
// // if (comments == null) {
// // comments = new ArrayList<Comment>();
// // }
// // Comment comment = new Comment(rs.getLong("c_id"), rs.getString("c_text"),
// // rs.getLong("c_blogid"),
// // rs.getDate("c_created_at"));
// // comments.add(comment);
// // blog.setComments(comments);
// // }

// return blog;
// }

// }
