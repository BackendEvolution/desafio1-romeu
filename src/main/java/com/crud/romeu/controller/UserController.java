package com.crud.romeu.controller;

import com.crud.romeu.domain.User;
import com.crud.romeu.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    //Estou a dizer que essa dependencia será injetada automaticamente
    @Autowired
    private UserServices userServices;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userServices.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userServices.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userServices.getUserById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return this.userServices.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userServices.deleteUser(id);
    }
}
