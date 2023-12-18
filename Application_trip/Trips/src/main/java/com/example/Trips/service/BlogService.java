package com.example.Trips.service;

import com.example.Trips.client.Data;
import com.example.Trips.model.Blog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogService {

    private Data client;

    public List<Blog> getAllBlogs() {
        return client.findAll();
    }

    public Optional<Blog> getBlogById(long id) {
        return client.findById(id);
    }

    public Blog saveBlog(Blog blog) {
        return client.save(blog);
    }

    public void deleteBlog(long id) {
        client.deleteById(id);
    }
}
