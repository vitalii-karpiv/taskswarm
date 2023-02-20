package com.karpiv.taskswarm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TASKS")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String title;

  @NotBlank
  private String description;

  @NotNull
  private LocalDate dueDate;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  // Constructors, getters, and setters
}

