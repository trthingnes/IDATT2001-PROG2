package edu.ntnu.tobiasth.idatt2001.hospital.person.employee;

import edu.ntnu.tobiasth.idatt2001.hospital.Hospital;
import edu.ntnu.tobiasth.idatt2001.hospital.person.Person;

/**
 * People who work at the {@link Hospital} all inherit the {@link Employee} class.
 *
 * @author trthingnes
 */
public class Employee extends Person {
  /**
   * Constructs a new {@link Employee} object.
   *
   * @param firstName Employee first name
   * @param lastName Employee last name
   * @param personalIdNumber Employee personal ID number
   * @author trthingnes
   */
  public Employee(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }
}
