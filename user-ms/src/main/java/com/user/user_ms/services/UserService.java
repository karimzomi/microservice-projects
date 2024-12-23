package com.user.user_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.user_ms.entities.User;
import com.user.user_ms.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User user) {
        User entity = userRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setName(user.getName());
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
            return userRepository.save(entity);
        }
        return null;
    }

}
