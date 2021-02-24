package edu.ntnu.tobiasth.idatt2001.hospital.person;

/**
 * A patient is a {@link Person} admitted to the hospital. Implements {@link Diagnosable} to allow
 * doctors to set diagnosis.
 *
 * @author trthingnes
 */
public class Patient extends Person implements Diagnosable {
  private String diagnosis = "";

  /**
   * {@inheritDoc}
   *
   * @param firstName Patient first name
   * @param lastName Patient last name
   * @param personalIdNumber Patient personal ID number
   * @author trthingnes
   */
  public Patient(String firstName, String lastName, String personalIdNumber) {
    super(firstName, lastName, personalIdNumber);
  }

  /**
   * Get diagnosis string.
   *
   * @return Diagnosis string
   * @author trthingnes
   */
  public String getDiagnosis() {
    return diagnosis;
  }

  /**
   * {@inheritDoc}
   *
   * @param diagnosis Diagnosis string
   * @author trthingnes
   */
  @Override
  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  /**
   * Get string version of object.
   *
   * @return Object string
   * @author trthingnes
   */
  @Override
  public String toString() {
    return String.format("%s and diagnosis '%s'", super.toString(), diagnosis);
  }
}
