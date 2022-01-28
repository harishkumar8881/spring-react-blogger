package com.hkr.backend.dao;

import java.util.List;

import com.hkr.backend.model.Blog;
import com.hkr.backend.model.Comment;

public interface BlogDao {
    public Long createBlog(Blog blog);

    public List<Blog> getBlogs();

    public Blog getBlogById(Long id);

    public void updateBlog(Blog blog, Long id);

    public void deleteBlog(Long id);

    public Long addCommentToBlog(Comment comment);
}
