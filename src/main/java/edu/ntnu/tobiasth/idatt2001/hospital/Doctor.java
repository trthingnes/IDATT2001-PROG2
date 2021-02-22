package edu.ntnu.tobiasth.idatt2001.hospital;

/**
 * Employees who can set diagnoses of {@link Patient} objects extend {@link Doctor}.
 */
public abstract class Doctor extends Employee {
    protected Doctor(String firstName, String lastName, String personalIdNumber) {
        super(firstName, lastName, personalIdNumber);
    }

    /**
     * Sets the diagnosis of the given {@link Patient}.
     * @param patient Patient to set the diagnosis of
     * @param diagnosis Diagnosis to assign to the patient
     */
    abstract void setDiagnosis(Patient patient, String diagnosis);
}
