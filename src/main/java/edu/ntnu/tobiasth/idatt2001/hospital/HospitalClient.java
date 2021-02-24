package edu.ntnu.tobiasth.idatt2001.hospital;

import edu.ntnu.tobiasth.idatt2001.hospital.exception.RemoveException;
import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Employee;

/**
 * Simple client program for {@link Hospital}.
 *
 * @author trthingnes
 */
public class HospitalClient {
  /**
   * Main method that runs the client.
   *
   * @param args Built-in arguments.
   * @author trthingnes
   */
  public static void main(String[] args) {
    Hospital stOlav = new Hospital("St. Olav hospital");
    HospitalTestData.fillRegisterWithTestData(stOlav);

    // Setup a department and people to remove.
    Department department = stOlav.getDepartments().get(0);
    Employee employeeToRemove = department.getEmployees().get(0);
    Patient patientToRemove = new Patient("Finn", "Esikke", "12345678910");

    try {
      // Should succeed.
      department.removePerson(employeeToRemove);

      // Should fail.
      department.removePerson(patientToRemove);
    } catch (RemoveException e) {
      System.err.printf("Could not remove the person! More info: %s", e.getMessage());
    }
  }
}
