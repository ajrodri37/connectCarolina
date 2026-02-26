package main.java;

import java.util.ArrayList;
import java.util.List;

public class AuthenticatorSimulation {

  public static void main(String[] args) {
    Student freshman = new Student("Amy", 730769523, 0);
    Adept cleTracker = new Adept();

    System.out.println(cleTracker.getCLECredits("Leadership Summit", new ArrayList<>()));

    List<Student> students = new ArrayList<>();
    students.add(freshman);

    Jedi.initStudents(students);

    boolean authenticationWindow = false;

    try {
      authenticationWindow = Jedi.duoAuthenticate(freshman, "Wednesday");
    } catch (IllegalArgumentException | DuoAuthenticationFailedException e) {
      System.out.println("Invalid for registration");
    } finally {
      System.out.println("Thank you for visiting ConnectCarolina");
      if (authenticationWindow) {
        System.out.println("You are authenticated for the next 10 minutes");
      } else {
        System.out.println("You will have to authenticate again");
      }
    }
  }
}
