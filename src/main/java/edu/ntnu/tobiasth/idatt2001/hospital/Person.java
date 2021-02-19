package edu.ntnu.tobiasth.idatt2001.hospital;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String personalIdNumber;

    protected Person(String firstName, String lastName, String personalIdNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdNumber = personalIdNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalIdNumber='" + personalIdNumber + '\'' +
                '}';
    }
}
