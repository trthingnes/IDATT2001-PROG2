package edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Employee;

/**
 * Employees who can set diagnoses of {@link Patient} objects extend {@link Doctor}.
 *
 * @author trthingnes
 */
public abstract class Doctor extends Employee {
  /**
   * Constructs a new {@link Doctor} object.
   *
   * @param firstName Doctor first name
   * @param lastName Doctor last name
   * @param personalIdNumber Doctor personal ID number
   * @author trthingnes
   */
  protected Doctor(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /**
   * Sets the diagnosis of the given {@link Patient}.
   *
   * @param patient Patient to set the diagnosis of
   * @param diagnosis Diagnosis to assign to the patient
   * @author trthingnes
   */
  abstract void setDiagnosis(Patient patient, String diagnosis);
}
