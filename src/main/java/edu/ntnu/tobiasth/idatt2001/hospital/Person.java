package edu.ntnu.tobiasth.idatt2001.hospital;

/**
 * A {@link Person} object contains a first name, last name and a personal ID number.
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String personalIdNumber;

    protected Person(String firstName, String lastName, String personalIdNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdNumber = personalIdNumber;
    }

    /**
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * @param firstName New first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * @param lastName New last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first and last name seperated by a space.
     * @return Full name
     */
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    /**
     * @return Personal ID number
     */
    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    /**
     * Set the personal ID number
     * @param personalIdNumber New personal ID number
     */
    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    /**
     * @return Object string
     */
    @Override
    public String toString() {
        return this.getClass().toString() + "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalIdNumber='" + personalIdNumber + '\'' +
                '}';
    }
}
