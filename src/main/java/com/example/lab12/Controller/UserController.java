package com.example.lab12.Controller;

import com.example.lab12.Model.User;
import com.example.lab12.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.update(id, user);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }
}
