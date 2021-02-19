package edu.ntnu.tobiasth.idatt2001.hospital;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Department {
    private String departmentName;
    private final HashMap<String, Patient> patients = new HashMap<>();
    private final HashMap<String, Employee> employees = new HashMap<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Patient> getPatients() {
        return (List<Patient>) patients.values();
    }

    public void addPatient(Patient patient) {
        patients.put(patient.getPersonalIdNumber(), patient);
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) employees.values();
    }

    public void addEmployee(Employee employee) {
        employees.putIfAbsent(employee.getPersonalIdNumber(), employee);
    }

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
