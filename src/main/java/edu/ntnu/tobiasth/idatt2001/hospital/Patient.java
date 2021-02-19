package edu.ntnu.tobiasth.idatt2001.hospital;

public class Patient extends Person implements Diagnosable {
    private String diagnosis;

    public Patient(String firstName, String lastName, String personalIdNumber) {
        super(firstName, lastName, personalIdNumber);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
