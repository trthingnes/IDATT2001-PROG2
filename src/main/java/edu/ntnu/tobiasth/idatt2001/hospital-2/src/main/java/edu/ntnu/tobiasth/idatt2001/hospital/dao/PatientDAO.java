package edu.ntnu.tobiasth.idatt2001.hospital.dao;

import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Accesses the {@link Patient} object in the database.
 * @author trthingnes
 */
public class PatientDAO {
    private final EntityManager em;

    /**
     * Creates a new data access object and database connection.
     */
    public PatientDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Gets the {@link Patient} with the given personal ID number.
     *
     * @param pidNumber Personal ID number.
     * @return Patient.
     */
    public Optional<Patient> get(long pidNumber) {
        Patient patient = em.find(Patient.class, pidNumber);

        return Objects.isNull(patient) ? Optional.empty() : Optional.of(patient);
    }

    /**
     * Gets all the {@link Patient} objects in the database.
     *
     * @return List of patients.
     * @throws Exception If unable to retrieve patients.
     */
    public List<Patient> getAll() throws Exception {
        try {
            Query query = em.createQuery("SELECT p FROM Patient p");
            return query.getResultList();
        } catch(Exception e) {
            throw new Exception("Unable to retrieve all patients: " + e.getMessage());
        }
    }

    /**
     * Creates the patient if it does not exist, and updates it if it does.
     *
     * @param patient Patient to create or update.
     * @throws Exception If unable to create/update patient.
     */
    public void createOrUpdate(Patient patient) throws Exception {
        if(exists(patient.getPidNumber())) {
            update(patient);
        }
        else {
            create(patient);
        }
    }

    /**
     * Attempts to create the given patient.
     *
     * @param patient Patient to create.
     * @throws Exception If unable to create patient.
     */
    public void create(Patient patient) throws Exception {
        EntityTransaction transaction = null;

        try {
            if(exists(patient.getPidNumber())) {
                throw new EntityExistsException("Patient with given PID number already exists.");
            }

            transaction = em.getTransaction();
            transaction.begin();

            em.persist(patient);

            transaction.commit();
        } catch(Exception e) {
            if(Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new Exception("Unable to create patient: " + e.getMessage());
        }
    }

    /**
     * Attempts to update the given patient.
     *
     * @param patient Patient to update.
     * @throws Exception If unable to update patient.
     */
    public void update(Patient patient) throws Exception {
        EntityTransaction transaction = null;

        try {
            if(!exists(patient.getPidNumber())) {
                throw new IllegalArgumentException("Patient does not exist.");
            }

            transaction = em.getTransaction();
            transaction.begin();

            em.merge(patient);

            transaction.commit();
        } catch(Exception e) {
            if(Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new Exception("Unable to update patient: " + e.getMessage());
        }
    }

    /**
     * Attempts to delete the given patient.
     *
     * @param patient Patient to delete.
     * @throws Exception If unable to delete patient.
     */
    public void delete(Patient patient) throws Exception {
        EntityTransaction transaction = null;

        try {
            if(!exists(patient.getPidNumber())) {
                throw new IllegalArgumentException("Patient does not exist.");
            }

            transaction = em.getTransaction();
            transaction.begin();

            em.remove(patient);

            transaction.commit();
        } catch(Exception e) {
            if(Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new Exception("Unable to delete patient: " + e.getMessage());
        }
    }

    /**
     * Attempts to delete all patients in the database.
     *
     * @throws Exception If unable to delete all patients.w
     */
    public void deleteAll() throws Exception {
        try {
            Query query = em.createQuery("DELETE FROM Patient p");
            query.executeUpdate();
        } catch(Exception e) {
            throw new Exception("Unable to delete all patients: " + e.getMessage());
        }
    }

    /**
     * Checks if a {@link Patient} with the given personal ID number exists.
     *
     * @param pidNumber Personal ID number.
     * @return True if patient exists, false if not.
     */
    public boolean exists(long pidNumber) {
        return Objects.nonNull(em.find(Patient.class, pidNumber));
    }
}