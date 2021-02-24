package edu.ntnu.tobiasth.idatt2001.hospital;

import edu.ntnu.tobiasth.idatt2001.hospital.exception.RemoveException;
import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.person.Person;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Employee;

import java.util.*;

/**
 * Model of a hospital department. Belongs to a {@link Hospital} object and has objects of type
 * {@link Patient} and {@link Employee}.
 *
 * @author trthingnes
 */
public class Department {
  private final HashMap<String, Patient> patients = new HashMap<>();
  private final HashMap<String, Employee> employees = new HashMap<>();
  private String departmentName;

  /**
   * Constructs a new department with the given name.
   *
   * @param departmentName Department name
   * @author trthingnes
   */
  public Department(String departmentName) {
    this.departmentName = departmentName;
  }

  /**
   * Gets the department name
   *
   * @return Department name
   * @author trthingnes
   */
  public String getDepartmentName() {
    return departmentName;
  }

  /**
   * Sets the department name
   * @param departmentName New department name
   *
   * @author trthingnes
   */
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  /**
   * Gets a list of all the {@link Patient} objects for this department.
   *
   * @return List of patients
   * @author trthingnes
   */
  public List<Patient> getPatients() {
    return new ArrayList<>(patients.values());
  }

  /**
   * Adds a new patient to this department.
   *
   * @param patient Patient to add
   * @author trthingnes
   */
  public void addPatient(Patient patient) {
    patients.put(patient.getPersonalIdNumber(), patient);
  }

  /**
   * Gets a list of all the {@link Employee} objects for this department.
   *
   * @return List of employees
   * @author trthingnes
   */
  public List<Employee> getEmployees() {
    return new ArrayList<>(employees.values());
  }

  /**
   * Adds a new employee to this department.
   *
   * @param employee Employee to add
   * @author trthingnes
   */
  public void addEmployee(Employee employee) {
    employees.putIfAbsent(employee.getPersonalIdNumber(), employee);
  }

  /**
   * Removes a {@link Patient} or {@link Employee} object from the respective map.
   *
   * @param person {@link Person} object to remove.
   * @throws RemoveException If the given person cannot be found.
   * @author trthingnes
   */
  public void removePerson(Person person) throws RemoveException {
    // Attempt to find a patient and an employee that matches the given person.
    Optional<Patient> patient = patients.values().stream().filter(person::equals).findFirst();
    Optional<Employee> employee = employees.values().stream().filter(person::equals).findFirst();

    // If neither a patient nor an employee was found, throw a RemoveException.
    if (patient.isEmpty() && employee.isEmpty()) {
      throw new RemoveException(String.format("%s does not exist.", person.toString()));
    }

    // Remove the patient/employee if they were present in the optional.
    patient.ifPresent(value -> patients.remove(value.getPersonalIdNumber()));
    employee.ifPresent(value -> employees.remove(value.getPersonalIdNumber()));
  }

  /**
   * Checks if two {@link Department} objects are equal.
   *
   * @param o Another object
   * @return True if objects are equal, false if not.
   * @author trthingnes
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Department that = (Department) o;

    if (!Objects.equals(departmentName, that.departmentName)) return false;
    if (!patients.equals(that.patients)) return false;
    return employees.equals(that.employees);
  }

  /**
   * Get object hashcode.
   *
   * @return Object hashcode
   * @author trthingnes
   */
  @Override
  public int hashCode() {
    int result = departmentName != null ? departmentName.hashCode() : 0;
    result = 31 * result + patients.hashCode();
    result = 31 * result + employees.hashCode();
    return result;
  }

  /**
   * Get a string version of the object.
   *
   * @return Object string
   * @author trthingnes
   */
  @Override
  public String toString() {
    return String.format("Department %s", departmentName);
  }
}
