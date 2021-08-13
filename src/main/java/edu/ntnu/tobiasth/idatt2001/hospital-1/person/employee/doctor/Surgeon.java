package edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;

/**
 * Surgeons inherit from the {@link Doctor} class to specify their field of work.
 *
 * @author trthingnes
 */
public class Surgeon extends Doctor {
  /**
   * Constructs a new {@link Surgeon} object.
   *
   * @param firstName Surgeon first name
   * @param lastName Surgeon last name
   * @param personalIdNumber Surgeon personal ID number
   * @author trthingnes
   */
  public Surgeon(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /**
   * {@inheritDoc}
   *
   * @param patient Patient to set the diagnosis of
   * @param diagnosis Diagnosis to assign to the patient
   * @author trthingnes
   */
  @Override
  void setDiagnosis(Patient patient, String diagnosis) {
    patient.setDiagnosis(diagnosis);
  }
}
