package com.ebooksstore;


import com.ebooksstore.entity.User;
import com.ebooksstore.repository.UserRepository;
import com.ebooksstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        users.addAll(userRepository.findAll());
        return users;
    }
}
