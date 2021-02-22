package edu.ntnu.tobiasth.idatt2001.hospital.person.employee;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Person;

/** People who work at the hospital all inherit the {@link Employee} class. */
public class Employee extends Person {
  public Employee(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /**
   * {@inheritDoc}
   *
   * @return Object string
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
