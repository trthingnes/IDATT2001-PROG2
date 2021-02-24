package edu.ntnu.tobiasth.idatt2001.hospital.person;

/**
 * {@link Person} contains a first name, last name and a personal ID number.
 *
 * @author trthingnes
 */
public abstract class Person {
  private String firstName;
  private String lastName;
  private String personalIdNumber;

  /**
   * Constructs a new {@link Person} object.
   *
   * @param firstName Person first name
   * @param lastName Person last name
   * @param personalIdNumber Person personal ID number
   * @author trthingnes
   */
  protected Person(String firstName, String lastName, String personalIdNumber) {
    this.firstName = firstName;
    this.lastName = lastName;

    try {
      this.personalIdNumber = String.valueOf(Long.parseLong(personalIdNumber));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(String.format("%s is not a number.", personalIdNumber));
    }
  }

  /**
   * Get the persons first name.
   *
   * @return First name
   * @author trthingnes
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the persons first name.
   *
   * @param firstName New first name
   * @author trthingnes
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get the persons last name.
   *
   * @return Last name
   * @author trthingnes
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the persons last name.
   *
   * @param lastName New last name
   * @author trthingnes
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the first and last name separated by a space.
   *
   * @return Full name
   * @author trthingnes
   */
  public String getFullName() {
    return String.format("%s %s", firstName, lastName);
  }

  /**
   * Get the persons personal ID number.
   *
   * @return Personal ID number
   * @author trthingnes
   */
  public String getPersonalIdNumber() {
    return personalIdNumber;
  }

  /**
   * Set the persons personal ID number.
   *
   * @param personalIdNumber New personal ID number
   * @author trthingnes
   */
  public void setPersonalIdNumber(String personalIdNumber) {
    this.personalIdNumber = personalIdNumber;
  }

  /**
   * Get string version of object.
   *
   * @return String object
   * @author trthingnes
   */
  @Override
  public String toString() {
    return String.format(
        "%s '%s', '%s' with id number '%s'",
        getClass().getSimpleName(), lastName, firstName, personalIdNumber);
  }
}
