package edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;

/**
 * GPs inherit from the {@link Doctor} class to specify their field of work.
 *
 * @author trthingnes
 */
public class GeneralPractitioner extends Doctor {
  /**
   * Constructs a new {@link GeneralPractitioner} object.
   *
   * @param firstName GP first name
   * @param lastName GP last name
   * @param personalIdNumber GP personal ID number
   * @author trthingnes
   */
  public GeneralPractitioner(String firstName, String lastName, String personalIdNumber) {
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
