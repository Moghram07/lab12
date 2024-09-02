package com.example.lab12.Service;

import com.example.lab12.Model.Blog;
import com.example.lab12.Model.User;
import com.example.lab12.Repositroy.BlogRepositroy;
import com.example.lab12.Repositroy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepositroy blogRepositroy;
    private final UserRepository userRepository;

    public List<Blog> getAllBlogs() {
        return blogRepositroy.findAll();
    }

    public void addBlog(Blog blog, Integer userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        blog.setUser(user);
        blogRepositroy.save(blog);
    }

    public void update(Integer userId, Integer blogId, Blog blog) {
        User user = userRepository.findUserById(userId);
        Blog b = blogRepositroy.findBlogById(blogId);
        if (b == null) {
            throw new RuntimeException("Blog not found");
        } else if (blog.getId() != userId) {
            throw new RuntimeException("Blog not linked to user");
        }
        blog.setUser(user);
        b.setTitle(blog.getTitle());
        b.setBody(blog.getBody());
        blogRepositroy.save(b);
    }

    public void delete(Integer userId, Integer blogId) {
        User user = userRepository.findUserById(userId);
        Blog b = blogRepositroy.findBlogById(blogId);
        if (b == null) {
            throw new RuntimeException("Blog not found");
        } else if (b.getUser().getId() != userId) {
            throw new RuntimeException("Blog not linked to user");
        }
        blogRepositroy.deleteById(blogId);
    }

    public Blog getBlogbyIdandUserId(Integer userId, Integer blogId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Blog blog = blogRepositroy.findBlogByIdAndUserId(userId, blogId);
        if (blog == null) {
            throw new RuntimeException("Blog not found");
        }
        return blog;
    }

    public Blog getBlogbyTitle(String title) {
        Blog blog = blogRepositroy.findBlogByTitle(title);
        if (blog == null) {
            throw new RuntimeException("Blog not found");
        }
        return blog;
    }
}