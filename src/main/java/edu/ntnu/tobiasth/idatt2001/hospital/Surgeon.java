package edu.ntnu.tobiasth.idatt2001.hospital;

/**
 * Surgeons inherit from the {@link Doctor} class to specify their field.
 */
public class Surgeon extends Doctor {
    public Surgeon(String firstName, String lastName, String personalIdNumber) {
        super(firstName, lastName, personalIdNumber);
    }

    /**
     * {@inheritDoc}
     * @param patient Patient to set the diagnosis of
     * @param diagnosis Diagnosis to assign to the patient
     */
    @Override
    void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
