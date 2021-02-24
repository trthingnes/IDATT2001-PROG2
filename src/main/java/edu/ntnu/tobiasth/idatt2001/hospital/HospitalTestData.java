package edu.ntnu.tobiasth.idatt2001.hospital;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Employee;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Nurse;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor.GeneralPractitioner;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor.Surgeon;

public class HospitalTestData {
  /**
   * Hidden constructor to assure static use only.
   *
   * @author trthingnes
   */
  private HospitalTestData() {}

  /**
   * Fills the given hospital with test data.
   *
   * @param hospital Hospital to fill with test data
   * @return Filled hospital
   * @author Lecturer, trthingnes
   */
  public static Hospital fillRegisterWithTestData(Hospital hospital) {
    Department emergency = new Department("Akutten");
    emergency.addEmployee(new Employee("Odd Even", "Primtallet", "11111111111"));
    emergency.addEmployee(new Employee("Huppasahn", "DelFinito", "22222222222"));
    emergency.addEmployee(new Employee("Rigmor", "Mortis", "33333333333"));
    emergency.addEmployee(new GeneralPractitioner("Inco", "Gnito", "44444444444"));
    emergency.addEmployee(new Surgeon("Inco", "Gnito", "55555555555"));
    emergency.addEmployee(new Nurse("Nina", "Teknologi", "66666666666"));
    emergency.addEmployee(new Nurse("Ove", "Ralt", "77777777777"));
    emergency.addPatient(new Patient("Inga", "Lykke", "88888888888"));
    emergency.addPatient(new Patient("Ulrik", "Smål", "99999999999"));
    hospital.addDepartment(emergency);

    Department childrenPolyclinic = new Department("Barn poliklinikk");
    childrenPolyclinic.addEmployee(new Employee("Salti", "Kaffen", "11111111111"));
    childrenPolyclinic.addEmployee(new Employee("Nidel V.", "Elvefølger", "22222222222"));
    childrenPolyclinic.addEmployee(new Employee("Anton", "Nym", "33333333333"));
    childrenPolyclinic.addEmployee(new GeneralPractitioner("Gene", "Sis", "44444444444"));
    childrenPolyclinic.addEmployee(new Surgeon("Nanna", "Na", "55555555555"));
    childrenPolyclinic.addEmployee(new Nurse("Nora", "Toriet", "66666666666"));
    childrenPolyclinic.addPatient(new Patient("Hans", "Omvar", "77777777777"));
    childrenPolyclinic.addPatient(new Patient("Laila", "La", "88888888888"));
    childrenPolyclinic.addPatient(new Patient("Jøran", "Drebli", "99999999999"));
    hospital.addDepartment(childrenPolyclinic);

    return hospital;
  }
}
