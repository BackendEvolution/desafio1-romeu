package com.crud.romeu.service;

import com.crud.romeu.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserInterface {
    User createUser(User user);
    List<User> getUsers();
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
}
