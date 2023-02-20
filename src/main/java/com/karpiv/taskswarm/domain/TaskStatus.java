package com.karpiv.taskswarm.domain;

public enum TaskStatus {
  CREATED("Created"),
  IN_PROGRESS("In Progress"),
  COMPLETED("Completed"),
  CANCELED("Canceled");

  private final String displayName;

  TaskStatus(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
