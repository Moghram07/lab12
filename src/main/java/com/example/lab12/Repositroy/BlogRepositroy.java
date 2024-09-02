package com.example.lab12.Repositroy;

import com.example.lab12.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepositroy extends JpaRepository<Blog, Integer> {
    Blog findBlogById(Integer id);
    Blog findBlogByTitle(String title);
    Blog findBlogByIdAndUserId(Integer userId, Integer id);
}
