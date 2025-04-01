package com.example.lostandfound.service;

import com.example.lostandfound.model.User;
import com.example.lostandfound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // 变量名改为小写开头更符合规范

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {  // 添加了参数名
        if (userRepository.findByName(user.getName()) != null) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedTime(LocalDateTime.now());
        userRepository.save(user);
    }
}