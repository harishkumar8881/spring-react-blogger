package com.hkr.backend.controller;

import java.util.List;

import com.hkr.backend.model.Blog;
import com.hkr.backend.service.BlogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /*
     * http://localhost:5432/api/blog/
     * Get the list of blogs
     */
    @GetMapping()
    public ResponseEntity<List<Blog>> getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    /*
     * http://localhost:5432/api/blog/<id>
     * Get a single Blog with id
     */
    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    /* 
       POST http://localhost:5432/api/blog 
       Create the blog
     */
    @PostMapping()
    public ResponseEntity<Long> createBlog(@RequestBody Blog blog) {
        return new ResponseEntity<Long>(blogService.createBlog(blog), HttpStatus.CREATED);
    }

    /* 
        PUT http://localhost:5432/api/blog/<id>
        Update the blog
     */
    @PutMapping("{id}")
    public ResponseEntity<Void> updateBlog(@RequestBody Blog blog,@PathVariable("id") Long id) {
        blogService.updateBlog(blog, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    /* 
        DELETE http://localhost:5432/api/blog/<id>
        Delete the blog
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
