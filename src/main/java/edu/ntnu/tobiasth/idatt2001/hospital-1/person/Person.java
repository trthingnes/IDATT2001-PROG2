package edu.ntnu.tobiasth.idatt2001.hospital.person;

/**
 * {@link Person} contains a first name, last name and a personal ID number.
 *
 * @author trthingnes
 */
public abstract class Person {
  private final String personalIdNumber;
  private String firstName;
  private String lastName;

  /**
   * Constructs a new {@link Person} object.
   *
   * @param firstName Person first name
   * @param lastName Person last name
   * @param personalIdNumber Person personal ID number
   * @author trthingnes
   */
  protected Person(String firstName, String lastName, String personalIdNumber) {
    if (firstName.isBlank() || lastName.isBlank()) {
      throw new IllegalArgumentException("First/Last name cannot be blank.");
    }

    this.firstName = firstName;
    this.lastName = lastName;

    try {
      this.personalIdNumber = String.valueOf(Long.parseLong(personalIdNumber));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          String.format("Personal ID Number cannot be \"%s\".", personalIdNumber));
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
