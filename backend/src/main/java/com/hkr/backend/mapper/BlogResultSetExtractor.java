package com.hkr.backend.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hkr.backend.model.Blog;
import com.hkr.backend.model.Comment;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class BlogResultSetExtractor implements ResultSetExtractor<List<Blog>> {

    @Override
    public List<Blog> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Blog> blogs = new HashMap<Long, Blog>();

        while (rs.next()) {
            //Get the blog
            Blog blog = blogs.get(rs.getLong("b_id"));
            if(blog == null){
                //If blog not exists in Map , Create new blog
                blog = new Blog();
                blog.setId(rs.getLong("b_id"));
                blog.setTitle(rs.getString("b_title"));
                blog.setContent(rs.getString("b_content"));
                blog.setCreated_at(rs.getDate("b_created_at"));
                blog.setComments(new ArrayList<Comment>());
            }

            //Create Comment only if it exists
            if(rs.getLong("c_id") != 0){
                Comment comment = new Comment();
                comment.setId(rs.getLong("c_id"));
                comment.setBlogid(rs.getLong("c_blogid"));
                comment.setCreated_at(rs.getDate("c_created_at"));
                comment.setText(rs.getString("c_text"));
                //Add Comment to the blog
                ArrayList<Comment> comments = blog.getComments(); 
                comments.add(comment);
                blog.setComments(comments);
            }

            //Add Blog to the map
            blogs.put(blog.getId(), blog);
        }
        return new ArrayList<Blog>(blogs.values());
    }

}
