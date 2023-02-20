package com.karpiv.taskswarm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 50)
  private String name;

  @NotBlank
  @Size(min = 3, max = 50)
  @Column(unique = true)
  private String email;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private Set<Task> tasks;

}






