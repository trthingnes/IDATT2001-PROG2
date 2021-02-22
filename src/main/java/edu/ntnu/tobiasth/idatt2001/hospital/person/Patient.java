package edu.ntnu.tobiasth.idatt2001.hospital.person;

/**
 * A patient is a {@link Person} admitted to the hospital. Implements {@link Diagnosable} to allow
 * doctors to set diagnosis.
 */
public class Patient extends Person implements Diagnosable {
  private String diagnosis;

  public Patient(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /** @return Diagnosis string */
  public String getDiagnosis() {
    return diagnosis;
  }

  /**
   * {@inheritDoc}
   *
   * @param diagnosis Diagnosis string
   */
  @Override
  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  /** @return Object string */
  @Override
  public String toString() {
    return "Patient{" + "diagnosis='" + diagnosis + '\'' + '}';
  }
}
