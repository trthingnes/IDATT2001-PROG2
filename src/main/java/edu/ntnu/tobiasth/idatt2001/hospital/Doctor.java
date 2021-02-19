package edu.ntnu.tobiasth.idatt2001.hospital;

public abstract class Doctor extends Employee {
    protected Doctor(String firstName, String lastName, String personalIdNumber) {
        super(firstName, lastName, personalIdNumber);
    }

    abstract void setDiagnosis(Patient patient, String diagnosis);
}
