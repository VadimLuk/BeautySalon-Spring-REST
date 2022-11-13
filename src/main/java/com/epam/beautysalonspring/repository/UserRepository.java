package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.Role;

import java.util.List;

public interface UserRepository {
    User findById(Long userId);
    User findByEmail(String email);
    List<User> findByRole(Role role);
    User create(User user);
    User update(User user);
}
