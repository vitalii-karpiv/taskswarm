package com.karpiv.taskswarm.controller;

import com.karpiv.taskswarm.domain.User;
import com.karpiv.taskswarm.exception.user.UserCreateException;
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
    if (user.getName().length() == 4) { // TODO: tesing code, remove before pull request
      throw new UserCreateException(UserCreateException.Error.INVALID_DTO_IN);
    }
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

