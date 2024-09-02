package com.example.lab12.Controller;

import com.example.lab12.Model.Blog;
import com.example.lab12.Model.User;
import com.example.lab12.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog, @AuthenticationPrincipal User user) {
        blogService.addBlog(blog, user.getId());
        return ResponseEntity.ok("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId, @Valid @RequestBody Blog blog) {
        blogService.update(user.getId(), blogId, blog);
        return ResponseEntity.ok("Blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId) {
        blogService.delete(user.getId(), blogId);
        return ResponseEntity.ok("Blog deleted");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBlogById(@AuthenticationPrincipal User user, @PathVariable Integer blogId) {
        return ResponseEntity.ok(blogService.getBlogbyIdandUserId(user.getId(), blogId));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title) {
        return ResponseEntity.ok(blogService.getBlogbyTitle(title));
    }
}
