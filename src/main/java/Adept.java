package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adept {
  private final Map<String, String> cleEvents = new HashMap<>();

  public Adept() {
    initCalendar();
  }

  public void initCalendar() {
    this.cleEvents.put("August 18", "Fall FDOC");
    this.cleEvents.put("September 06", "Honor Code Workshop");
    this.cleEvents.put("September 16", "AMEXCAN Independence Day GBM");
    this.cleEvents.put("September 21", "Coffee and Crochet at Meantime");
    this.cleEvents.put("October 12", "Leadership Summit");
    this.cleEvents.put("November 03", "Community Service Night");
    this.cleEvents.put("December 01", "Study Skills Clinic");
  }

  public void validateScan(String name, List<String> scannedEvents)
      throws CLEEventNotFoundException, CLEAlreadyScannedException {

    if (scannedEvents == null || name == null) {
      throw new IllegalArgumentException("name or scannedEvents cannot be null");
    }

    if (!this.cleEvents.containsValue(name)) {
      throw new CLEEventNotFoundException("This CLE Event does not exist");
    }

    if (scannedEvents.contains(name)) {
      throw new CLEAlreadyScannedException();
    }
  }

  public List<String> getCLECredits(String name, List<String> scannedEvents) {
    try {
      validateScan(name, scannedEvents);
      scannedEvents.add(name);
      System.out.println("Thank you for attending!");
    } catch (CLEAlreadyScannedException | CLEEventNotFoundException e) {
      System.out.println("Error scanning event: " + e.getMessage());
      return scannedEvents;
    }

    System.out.println("CLE credit processed for: " + name);
    return scannedEvents;
  }
}
