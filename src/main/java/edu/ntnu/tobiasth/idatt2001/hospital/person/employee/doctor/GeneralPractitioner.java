package edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;

/** SPs inherit from the {@link Doctor} class to specify their field. */
public class GeneralPractitioner extends Doctor {
  public GeneralPractitioner(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /**
   * {@inheritDoc}
   *
   * @param patient Patient to set the diagnosis of
   * @param diagnosis Diagnosis to assign to the patient
   */
  @Override
  void setDiagnosis(Patient patient, String diagnosis) {
    patient.setDiagnosis(diagnosis);
  }
}
