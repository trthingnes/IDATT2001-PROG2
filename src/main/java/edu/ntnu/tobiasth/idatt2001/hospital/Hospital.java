package edu.ntnu.tobiasth.idatt2001.hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of a hospital that contains {@link Department} objects.
 */
public class Hospital {
    private final String hospitalName;
    private final ArrayList<Department> departments = new ArrayList<>();

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return Hospital name
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @return List of departments
     */
    public List<Department> getDepartments() {
        return departments;
    }

    /**
     * Add a new department to the hospital.
     * @param department Department to add
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * @return Object string
     */
    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalName='" + hospitalName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
