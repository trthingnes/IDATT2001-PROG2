package edu.ntnu.tobiasth.idatt2001.hospital;

import java.util.*;

/**
 * Model of a hospital department.
 * Belongs to a {@link Hospital} object and has objects of type {@link Patient} and {@link Employee}.
 */
public class Department {
    private String departmentName;
    private final HashMap<String, Patient> patients = new HashMap<>();
    private final HashMap<String, Employee> employees = new HashMap<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return Department name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName New department name
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets a list of all the {@link Patient} objects for this department.
     * @return List of patients
     */
    public List<Patient> getPatients() {
        return new ArrayList<>(patients.values());
    }

    /**
     * Adds a new patient to this department.
     * @param patient Patient to add
     */
    public void addPatient(Patient patient) {
        patients.put(patient.getPersonalIdNumber(), patient);
    }

    /**
     * Gets a list of all the {@link Employee} objects for this department.
     * @return List of employees
     */
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    /**
     * Adds a new employee to this department.
     * @param employee Employee to add
     */
    public void addEmployee(Employee employee) {
        employees.putIfAbsent(employee.getPersonalIdNumber(), employee);
    }

    /**
     * Removes a {@link Patient} or {@link Employee} object from the respective map.
     * @param person {@link Person} object to remove.
     * @throws RemoveException If the given person cannot be found.
     */
    public void removePerson(Person person) throws RemoveException {
        Optional<Patient> patient = patients.values().stream().filter(person::equals).findFirst();
        Optional<Employee> employee = employees.values().stream().filter(person::equals).findFirst();

        if(patient.isEmpty() && employee.isEmpty()) {
            throw new RemoveException("Could not find the given person.");
        }

        patient.ifPresent(value -> patients.remove(value.getPersonalIdNumber()));
        employee.ifPresent(value -> employees.remove(value.getPersonalIdNumber()));
    }

    /**
     * Checks if two {@link Department} objects are equal.
     * @param o Another object
     * @return True if objects are equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!Objects.equals(departmentName, that.departmentName))
            return false;
        if (!patients.equals(that.patients)) return false;
        return employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        int result = departmentName != null ? departmentName.hashCode() : 0;
        result = 31 * result + patients.hashCode();
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", patients=" + patients +
                ", employees=" + employees +
                '}';
    }
}
