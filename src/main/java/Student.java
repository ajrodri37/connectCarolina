package main.java;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private final String name;
  private final int credits;
  private final int studentID;
  private List<String> events;

  public Student(String name, int studentID, int credits) {
    this.name = name;
    this.studentID = studentID;
    this.credits = credits;
    this.events = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public int getStudentID() {
    return studentID;
  }

  public int getCredits() {
    return credits;
  }

  public List<String> getScannedCLEEvents() {
    return events;
  }

  public void setCLEEvents(List<String> events) {
    this.events = events;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Student) {
      return this.studentID == ((Student) o).getStudentID();
    }

    return false;
  }
}
