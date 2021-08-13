import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    private final String fName = "John";
    private final String lName = "Deer";
    private final String drName = "Dr. Dø";
    private final String validIdNumber = "10101055555";
    private final String invalidIdNumber = "101010555555";

    @Test
    @DisplayName("Patient get created successfully")
    void testPatientGetsCreatedSuccessfully() {
        assertDoesNotThrow(() -> { new Patient(validIdNumber, fName, lName, drName); });
    }

    @Test
    @DisplayName("Patient data is correct after creation")
    void testPatientDataIsCorrectAfterCreate() {
        Patient p = new Patient(validIdNumber, fName, lName, drName);
        boolean fNameCorrect = fName.equals(p.getFirstName());
        boolean lNameCorrect = lName.equals(p.getLastName());
        boolean drNameCorrect = drName.equals(p.getDoctorName());

        assertTrue(fNameCorrect && lNameCorrect && drNameCorrect);
    }

    @Test
    @DisplayName("Patient with invalid ID number cannot be created")
    void testInvalidIdNumberCausesExceptionOnCreate() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(invalidIdNumber, fName, lName, drName));
    }

    @Test
    @DisplayName("Patient with invalid name cannot be created")
    void testInvalidNameCausesExceptionOnCreate() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(invalidIdNumber, "", lName, drName));
    }

    @Test
    @DisplayName("Patient data is correct after update")
    void testPatientDataIsCorrectAfterUpdate() {
        Patient p = new Patient(validIdNumber, fName, lName, drName);

        String newFName = "Jack";
        String newLName = "Black";
        String newDrName = "Dr. Klø";

        p.setFirstName(newFName);
        p.setLastName(newLName);
        p.setDoctorName(newDrName);
        boolean fNameCorrect = newFName.equals(p.getFirstName());
        boolean lNameCorrect = newLName.equals(p.getLastName());
        boolean drNameCorrect = newDrName.equals(p.getDoctorName());

        assertTrue(fNameCorrect && lNameCorrect && drNameCorrect);
    }

    @Test
    @DisplayName("Patient cannot be updated with invalid ID number")
    void testInvalidIdNumberCausesExceptionOnUpdate() {
        Patient p = new Patient(validIdNumber, fName, lName, drName);

        assertThrows(NumberFormatException.class, () -> p.setPidNumber(invalidIdNumber));
    }

    @Test
    @DisplayName("Patient cannot be updated with name")
    void testInvalidNameCausesExceptionOnUpdate() {
        Patient p = new Patient(validIdNumber, fName, lName, drName);

        assertThrows(IllegalArgumentException.class, () -> p.setFirstName(""));
    }
}
