import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.dao.PatientDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.Persistence;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientDAOTest {
    private final String fName = "John";
    private final String lName = "Deer";
    private final String drName = "Dr. Dø";
    private final String validIdNumber = "10101055555";
    private final String invalidIdNumber = "101010555555";
    private final PatientDAO patientDAO = new PatientDAO(Persistence.createEntityManagerFactory("pu-derby-test").createEntityManager());

    @Test
    @DisplayName("Patient data is correct after patient is created.")
    @Transactional
    void testPatientDataIsCorrectAfterCreate() throws Exception {
        patientDAO.create(new Patient(validIdNumber, fName, lName, drName));

        Patient p = patientDAO.get(Long.parseLong(validIdNumber)).get();
        boolean fNameCorrect = fName.equals(p.getFirstName());
        boolean lNameCorrect = lName.equals(p.getLastName());
        boolean drNameCorrect = drName.equals(p.getDoctorName());

        assertTrue(fNameCorrect && lNameCorrect && drNameCorrect);
    }

    @Test
    @DisplayName("Patient data is correct after patient is updated.")
    @Transactional
    void testPatientDataIsCorrectAfterUpdate() throws Exception {
        String newFName = "Jack";
        String newLName = "Black";
        String newDrName = "Dr. Klø";

        Patient p = new Patient(validIdNumber, fName, lName, drName);
        patientDAO.create(p);
        p.setFirstName(newFName);
        p.setLastName(newLName);
        p.setDoctorName(newDrName);
        patientDAO.update(p);
        p = patientDAO.get(Long.parseLong(validIdNumber)).get();

        boolean fNameCorrect = newFName.equals(p.getFirstName());
        boolean lNameCorrect = newLName.equals(p.getLastName());
        boolean drNameCorrect = newDrName.equals(p.getDoctorName());

        assertTrue(fNameCorrect && lNameCorrect && drNameCorrect);
    }

    @Test
    @DisplayName("Patient data is removed after delete.")
    @Transactional
    void testPatientIsRemovedAfterDelete() throws Exception {
        Patient p = new Patient(validIdNumber, fName, lName, drName);
        patientDAO.create(p);
        patientDAO.delete(p);

        assertTrue(patientDAO.get(Long.parseLong(validIdNumber)).isEmpty());
    }
}
