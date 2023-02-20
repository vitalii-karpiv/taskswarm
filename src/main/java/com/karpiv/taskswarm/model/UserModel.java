package com.karpiv.taskswarm.model;

import com.karpiv.taskswarm.domain.User;
import com.karpiv.taskswarm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserModel {

  private final UserRepository userRepository;

  public UserModel(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(Long userId, User updatedUser) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      User existingUser = user.get();
      existingUser.setName(updatedUser.getName());
      existingUser.setEmail(updatedUser.getEmail());
      existingUser.setTasks(updatedUser.getTasks());
      return userRepository.save(existingUser);
    } else {
      throw new RuntimeException("Task not found with id: " + userId);
    }
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}

