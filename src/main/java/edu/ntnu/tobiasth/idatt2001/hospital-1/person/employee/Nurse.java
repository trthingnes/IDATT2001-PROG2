package edu.ntnu.tobiasth.idatt2001.hospital.person.employee;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;

/**
 * {@link Nurse} is an employee who cannot set {@link Patient} diagnoses.
 *
 * @author trthingnes
 */
public class Nurse extends Employee {
  /**
   * Constructs a new {@link Nurse} object.
   *
   * @param firstName Nurse first name
   * @param lastName Nurse last name
   * @param personalIdNumber Nurse personal ID number
   * @author trthingnes
   */
  public Nurse(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }
}
