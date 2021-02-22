package edu.ntnu.tobiasth.idatt2001.hospital.person;

/** Classes extending {@link Person} that can be given a diagnosis implement {@link Diagnosable}. */
public interface Diagnosable {
  /**
   * Set the diagnosis of the given person.
   *
   * @param diagnosis Diagnosis string
   */
  void setDiagnosis(String diagnosis);
}
