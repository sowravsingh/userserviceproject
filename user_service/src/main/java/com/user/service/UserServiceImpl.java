package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> list=List.of(
            new User(1311L,"sowrav","12345"),
            new User(1312L,"teja","54321"),
            new User(1313L,"sowrav","56789")
    );
    @Override
    public User getUser(Long id) {
        return this.list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
