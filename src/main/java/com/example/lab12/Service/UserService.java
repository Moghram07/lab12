package com.example.lab12.Service;

import com.example.lab12.Model.User;
import com.example.lab12.Repositroy.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void registerUser(User user) {
        user.setRole("USER");
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
    }

    public User update(Integer id, User user) {
        User u = userRepository.findUserById(id);
        if(u == null) {
            throw new RuntimeException("User not found");
        }
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        u.setPassword(hash);
        u.setUsername(user.getUsername());
        return userRepository.findUserById(id);
    }

    public void delete(Integer id) {
        User u = userRepository.findUserById(id);
        if(u == null) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

}
