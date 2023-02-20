package com.karpiv.taskswarm.controllers;

import com.karpiv.taskswarm.domain.User;
import com.karpiv.taskswarm.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserModel userModel;

  public UserController(UserModel userModel) {
    this.userModel = userModel;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userModel.getAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userModel.getUserById(id).get();
  }

  @PostMapping
  public User createUser(@Valid @RequestBody User user) {
    return userModel.saveUser(user);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
    return userModel.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userModel.deleteUser(id);
  }
}

