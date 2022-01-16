package com.hkr.backend.service;

import java.util.List;

import com.hkr.backend.model.Blog;

public interface BlogService {
    public Long createBlog(Blog blog);

    public List<Blog> getBlogs();

    public Blog getBlogById(Long id);

    public void updateBlog(Blog blog, Long id);

    public void deleteBlog(Long id);
}
