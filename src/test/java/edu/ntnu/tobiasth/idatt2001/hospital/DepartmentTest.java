package edu.ntnu.tobiasth.idatt2001.hospital;

import edu.ntnu.tobiasth.idatt2001.hospital.exception.RemoveException;
import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Employee;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Nurse;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor.GeneralPractitioner;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor.Surgeon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Department tests")
class DepartmentTest {
  @Test
  @DisplayName("Employee is removed when supposed to")
  void testEmployeeIsRemovedCorrectly() throws RemoveException {
    Hospital hospital = HospitalTestData.fillRegisterWithTestData(new Hospital("St. Olav"));
    Department department = hospital.getDepartments().get(0);

    int sizeBefore = department.getEmployees().size();
    department.removePerson(department.getEmployees().get(0));
    int sizeAfter = department.getEmployees().size();

    assertEquals(sizeAfter + 1, sizeBefore);
  }

  @Test
  @DisplayName("Patient is removed when supposed to")
  void testPatientIsRemovedCorrectly() throws RemoveException {
    Hospital hospital = HospitalTestData.fillRegisterWithTestData(new Hospital("St. Olav"));
    Department department = hospital.getDepartments().get(0);

    int sizeBefore = department.getPatients().size();
    department.removePerson(department.getPatients().get(0));
    int sizeAfter = department.getPatients().size();

    assertEquals(sizeAfter + 1, sizeBefore);
  }

  @Test
  @DisplayName("Removing non existent employee throws RemoveException")
  void testRemovingNonExistentEmployeeThrowsRemoveException() {
    Hospital hospital = HospitalTestData.fillRegisterWithTestData(new Hospital("St. Olav"));
    Department department = hospital.getDepartments().get(0);

    assertThrows(
        RemoveException.class,
        () -> department.removePerson(new Employee("Finn", "Esikke", "49239402312")));
  }

  @Test
  @DisplayName("Removing non existent patient throws RemoveException")
  void testRemovingNonExistentPatientThrowsRemoveException() {
    Hospital hospital = HospitalTestData.fillRegisterWithTestData(new Hospital("St. Olav"));
    Department department = hospital.getDepartments().get(0);

    assertThrows(
        RemoveException.class,
        () -> department.removePerson(new Patient("Finn", "Esikke", "49239402312")));
  }

  @Test
  @DisplayName(
      "Removing non existent patient where the info matches an employee throws RemoveException")
  void testRemovingNonExistentPatientWithInfoMatchingEmployeeThrowsRemoveException() {
    Hospital hospital = HospitalTestData.fillRegisterWithTestData(new Hospital("St. Olav"));
    Department department = hospital.getDepartments().get(0);

    String firstName = "Jan";
    String lastName = "Ansatt";
    String idNumber = "49201049832";

    department.addEmployee(new Employee(firstName, lastName, idNumber));

    assertThrows(
        RemoveException.class,
        () -> department.removePerson(new Patient(firstName, lastName, idNumber)));
  }

  @Test
  @DisplayName(
      "Removing non existent employee where the info matches a patient throws RemoveException")
  void testRemovingNonExistentEmployeeWithInfoMatchingPatientThrowsRemoveException() {
    Hospital hospital = HospitalTestData.fillRegisterWithTestData(new Hospital("St. Olav"));
    Department department = hospital.getDepartments().get(0);

    String firstName = "Jan";
    String lastName = "Ansatt";
    String idNumber = "49201049832";

    department.addPatient(new Patient(firstName, lastName, idNumber));

    assertThrows(
        RemoveException.class,
        () -> department.removePerson(new Employee(firstName, lastName, idNumber)));
  }
}
