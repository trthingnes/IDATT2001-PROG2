package edu.ntnu.tobiasth.idatt2001.hospital;

public class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(String firstName, String lastName, String personalIdNumber) {
        super(firstName, lastName, personalIdNumber);
    }

    @Override
    void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
