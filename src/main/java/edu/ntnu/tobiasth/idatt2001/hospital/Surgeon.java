package edu.ntnu.tobiasth.idatt2001.hospital;

public class Surgeon extends Doctor {
    public Surgeon(String firstName, String lastName, String personalIdNumber) {
        super(firstName, lastName, personalIdNumber);
    }

    @Override
    void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
