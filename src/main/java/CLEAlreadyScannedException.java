package main.java;

public class CLEAlreadyScannedException extends Exception {
  public CLEAlreadyScannedException(String message) {
    super(message);
  }

  public CLEAlreadyScannedException() {
    super("This item has already been scanned!");
  }
}
