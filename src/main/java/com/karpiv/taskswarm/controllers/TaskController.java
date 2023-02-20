package com.karpiv.taskswarm.controllers;

import com.karpiv.taskswarm.domain.Task;
import com.karpiv.taskswarm.model.TaskModel;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

  private final TaskModel taskModel;

  public TaskController(TaskModel taskModel) {
    this.taskModel = taskModel;
  }

  @GetMapping
  public List<Task> getAllTasks() {
    return taskModel.getAllTasks();
  }

  @GetMapping("/{id}")
  public Task getTaskById(@PathVariable Long id) {
    return taskModel.getTaskById(id).get();
  }

  @PostMapping
  public Task createTask(@Valid @RequestBody Task task) {
    return taskModel.createTask(task);
  }

  @PutMapping("/{id}")
  public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
    task.setId(id);
    return taskModel.updateTask(id, task);
  }

  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable Long id) {
    taskModel.deleteTask(id);
  }
}


