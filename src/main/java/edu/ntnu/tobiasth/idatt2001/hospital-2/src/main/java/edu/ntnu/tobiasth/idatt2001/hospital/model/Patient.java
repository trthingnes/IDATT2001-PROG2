package edu.ntnu.tobiasth.idatt2001.hospital.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Database and object model for patients.
 * @author trthingnes
 */
@Entity
public class Patient {
    @Id
    private long pidNumber;
    private String firstName;
    private String lastName;
    private String doctorName;
    private String diagnosis;

    /**
     * Empty constructor needed by persistence provider.
     */
    public Patient() {}

    /**
     * Create a new unique patient object.
     *
     * @param pidNumber Personal ID number.
     * @param firstName First name.
     * @param lastName Last name.
     * @param doctorName Doctors full name.
     */
    public Patient(String pidNumber, String firstName, String lastName, String doctorName) throws IllegalArgumentException {
        final long pid;

        try {
            pid = Long.parseLong(pidNumber);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("Personal ID number must be a number");
        }

        if(pid < 10000000000L || pid > 99999999999L) {
            throw new NumberFormatException("Personal ID number must be 11 digits");
        }

        if(firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("First and last names are required");
        }

        this.pidNumber = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorName = doctorName;
    }

    public long getPidNumber() {
        return pidNumber;
    }

    public void setPidNumber(String pidNumber) throws IllegalArgumentException {
        long pid;

        try {
            pid = Long.parseLong(pidNumber);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("Personal ID number must be a number");
        }

        if(pid < 10000000000L || pid > 99999999999L) {
            throw new NumberFormatException("Personal ID number must be 11 digits");
        }

        this.pidNumber = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if(firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be blank.");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if(lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be blank.");
        }

        this.lastName = lastName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return String.format("Patient %s, %s with ID number %s", lastName, firstName, pidNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return pidNumber == patient.pidNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pidNumber);
    }
}
