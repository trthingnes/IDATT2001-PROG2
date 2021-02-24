package edu.ntnu.tobiasth.idatt2001.hospital;

import java.util.ArrayList;
import java.util.List;

/** Model of a hospital that contains {@link Department} objects. */
public class Hospital {
  private final String hospitalName;
  private final ArrayList<Department> departments = new ArrayList<>();

  /**
   * Constructs a new hospital with the provided name.
   *
   * @param hospitalName Hospital name
   */
  public Hospital(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  /**
   * Gets the hospital name.
   *
   * @return Hospital name
   */
  public String getHospitalName() {
    return hospitalName;
  }

  /**
   * Gets the hospital departments.
   *
   * @return List of departments
   */
  public List<Department> getDepartments() {
    return departments;
  }

  /**
   * Add a new department to the hospital.
   *
   * @param department Department to add
   */
  public void addDepartment(Department department) {
    departments.add(department);
  }

  /**
   * Get a string version of the object.
   *
   * @return Object string
   */
  @Override
  public String toString() {
    return String.format("Hospital %s", hospitalName);
  }
}
