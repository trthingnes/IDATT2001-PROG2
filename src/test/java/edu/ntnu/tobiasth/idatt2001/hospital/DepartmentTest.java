package edu.ntnu.tobiasth.idatt2001.hospital;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Department tests")
class DepartmentTest {
    Department getTestDepartment() {
        Department department = new Department("Department");

        Employee gp = new GeneralPractitioner("Odd Even", "Primtallet", "12345612345");
        Employee surgeon = new Surgeon("Salti", "Kaffen", "44845678915");
        Employee nurse = new Nurse("Ove", "Ralt", "65432154321");

        Patient p1 = new Patient("Inco", "Gnito", "12345612345");
        Patient p2 = new Patient("Gene", "Sis", "65432154321");

        department.addEmployee(gp);
        department.addEmployee(surgeon);
        department.addEmployee(nurse);

        department.addPatient(p1);
        department.addPatient(p2);

        return department;
    }

    @Test
    @DisplayName("Employee is removed when supposed to")
    void testEmployeeIsRemovedCorrectly() throws RemoveException {
        Department department = getTestDepartment();

        int sizeBefore = department.getEmployees().size();
        department.removePerson(department.getEmployees().get(0));
        int sizeAfter = department.getEmployees().size();

        assertEquals(sizeAfter + 1, sizeBefore);
    }

    @Test
    @DisplayName("Patient is removed when supposed to")
    void testPatientIsRemovedCorrectly() throws RemoveException {
        Department department = getTestDepartment();

        int sizeBefore = department.getPatients().size();
        department.removePerson(department.getPatients().get(0));
        int sizeAfter = department.getPatients().size();

        assertEquals(sizeAfter + 1, sizeBefore);
    }

    @Test
    @DisplayName("Removing non existent employee throws RemoveException")
    void testRemovingNonExistentEmployeeThrowsRemoveException() {
        Department department = getTestDepartment();

        assertThrows(RemoveException.class, () -> {
            department.removePerson(new Employee("Finn", "Esikke", "49239402312"));
        });
    }

    @Test
    @DisplayName("Removing non existent patient throws RemoveException")
    void testRemovingNonExistentPatientThrowsRemoveException() {
        Department department = getTestDepartment();

        assertThrows(RemoveException.class, () -> {
            department.removePerson(new Patient("Finn", "Esikke", "49239402312"));
        });
    }

    @Test
    @DisplayName("Removing non existent patient where the info matches an employee throws RemoveException")
    void testRemovingNonExistentPatientWithInfoMatchingEmployeeThrowsRemoveException() {
        Department department = getTestDepartment();
        String firstName = "Jan";
        String lastName = "Ansatt";
        String idNumber = "49201049832";

        department.addEmployee(new Employee(firstName, lastName, idNumber));

        assertThrows(RemoveException.class, () -> {
            department.removePerson(new Patient(firstName, lastName, idNumber));
        });
    }

    @Test
    @DisplayName("Removing non existent employee where the info matches a patient throws RemoveException")
    void testRemovingNonExistentEmployeeWithInfoMatchingPatientThrowsRemoveException() {
        Department department = getTestDepartment();
        String firstName = "Jan";
        String lastName = "Ansatt";
        String idNumber = "49201049832";
        boolean threwException = false;

        department.addPatient(new Patient(firstName, lastName, idNumber));

        assertThrows(RemoveException.class, () -> {
            department.removePerson(new Employee(firstName, lastName, idNumber));
        });
    }
}
