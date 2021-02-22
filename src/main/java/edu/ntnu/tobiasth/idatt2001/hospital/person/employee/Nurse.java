package edu.ntnu.tobiasth.idatt2001.hospital.person.employee;

/** Employees who cannot set diagnoses inherit the {@link Nurse} class. */
public class Nurse extends Employee {
  public Nurse(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /** @return Object string */
  @Override
  public String toString() {
    return super.toString();
  }
}
