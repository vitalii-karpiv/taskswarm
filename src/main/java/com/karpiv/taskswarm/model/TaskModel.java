package com.karpiv.taskswarm.model;

import com.karpiv.taskswarm.domain.Task;
import com.karpiv.taskswarm.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskModel {

  private final TaskRepository taskRepository;

  public TaskModel(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public Optional<Task> getTaskById(Long taskId) {
    return taskRepository.findById(taskId);
  }

  public Task createTask(Task task) {
    return taskRepository.save(task);
  }

  public Task updateTask(Long taskId, Task updatedTask) {
    Optional<Task> task = taskRepository.findById(taskId);
    if (task.isPresent()) {
      Task existingTask = task.get();
      existingTask.setTitle(updatedTask.getTitle());
      existingTask.setDescription(updatedTask.getDescription());
      existingTask.setDueDate(updatedTask.getDueDate());
      existingTask.setStatus(updatedTask.getStatus());
      existingTask.setAssignee(updatedTask.getAssignee());
      return taskRepository.save(existingTask);
    } else {
      throw new RuntimeException("Task not found with id: " + taskId);
    }
  }

  public void deleteTask(Long taskId) {
    taskRepository.deleteById(taskId);
  }
}

