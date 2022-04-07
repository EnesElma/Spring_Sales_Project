package com.enes.user.service;

import com.enes.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User create(User user);

    void delete(Long id);

    List<User> listAll();

    Optional<User> findUser(Long id);
}
