package main.java;

public class DuoAuthenticationFailedException extends Exception {
  public DuoAuthenticationFailedException(String message) {
    super("Authentication failed: " + message);
  }
}
