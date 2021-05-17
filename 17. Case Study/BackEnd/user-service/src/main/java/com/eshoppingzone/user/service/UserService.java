package com.eshoppingzone.user.service;

import com.eshoppingzone.user.models.User;
import com.eshoppingzone.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(User user){
        log.info("registerNewUser method of UserService is called.");
        return userRepository.save(user);
    }

    public User getUserById(String username) {
        log.info("getUserById method of UserService is called.");
        return userRepository.findByUsername(username);
    }

    public User updateUser(User user) {
        log.info("updateUser method of UserService is called.");
        return userRepository.save(user);
    }
}
