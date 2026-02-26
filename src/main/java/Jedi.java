package main.java;

import java.util.*;

public class Jedi {

  private static final Map<String, Set<Student>> enrollment = new HashMap<>();

  public static void initStudents(List<Student> students) {
    enrollment.put("Monday", new HashSet<>());
    enrollment.put("Tuesday", new HashSet<>());
    enrollment.put("Wednesday", new HashSet<>());
    enrollment.put("Thursday", new HashSet<>());
    enrollment.put("Friday", new HashSet<>());

    if (students == null) {
      throw new IllegalArgumentException("Set of students cannot be null");
    }

    for (Student student : students) {
      if (student == null) {
        throw new IllegalArgumentException("Student cannot be null");
      }

      try {
        String enrollmentDay = calculateValidDay(student.getCredits());
        enrollment.get(enrollmentDay).add(student);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid credits");
      }
    }
  }

  public static String calculateValidDay(double numOfCredits) throws IllegalArgumentException {
    if (numOfCredits >= 0 && numOfCredits <= 55) {
      return "Wednesday";
    } else if (numOfCredits > 55 && numOfCredits <= 100) {
      return "Tuesday";
    } else if (numOfCredits > 100) {
      return "Monday";
    } else {
      throw new IllegalArgumentException("Invalid credits");
    }
  }

  public static boolean duoAuthenticate(Student student, String day)
      throws IllegalArgumentException, DuoAuthenticationFailedException {

    if (student == null) {
      throw new IllegalArgumentException("student cannot be null");
    }

    boolean authenticate = false;

    if (Integer.toString(student.getStudentID()).length() != 9) {
      throw new DuoAuthenticationFailedException("Student ID provided is invalid");
    }

    String enrollmentDay = calculateValidDay(student.getCredits());

    if (!day.equals(enrollmentDay)) {
      throw new DuoAuthenticationFailedException("Today is not your registration day");
    }

    if (!enrollment.get(day).contains(student)) {
      throw new DuoAuthenticationFailedException("Student not on approved registration list");
    }

    System.out.println("Duo authentication successful! Welcome, " + student.getName() + ".");
    authenticate = true;

    return authenticate;
  }
}
