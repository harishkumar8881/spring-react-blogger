package com.hkr.backend.service;

import java.util.List;

import com.hkr.backend.dao.BlogDao;
import com.hkr.backend.model.Blog;

import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogDao blogDao;

    public BlogServiceImpl(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public Long createBlog(Blog blog) {
        return blogDao.createBlog(blog);
    }

    @Override
    public List<Blog> getBlogs() {
        return blogDao.getBlogs();
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public void updateBlog(Blog blog, Long id) {
        Blog oldBlog = blogDao.getBlogById(id);
        if(oldBlog != null){
            blogDao.updateBlog(blog, id);
        }
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }
}
