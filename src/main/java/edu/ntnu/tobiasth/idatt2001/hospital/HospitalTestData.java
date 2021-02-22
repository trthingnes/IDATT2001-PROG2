package edu.ntnu.tobiasth.idatt2001.hospital;

import edu.ntnu.tobiasth.idatt2001.hospital.person.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Employee;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.Nurse;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor.GeneralPractitioner;
import edu.ntnu.tobiasth.idatt2001.hospital.person.employee.doctor.Surgeon;

public class HospitalTestData {
    private HospitalTestData() {}

    /**
     * Fills the given hospital with test data
     * @param hospital Hospital to fill with test data
     */
    public static Hospital fillRegisterWithTestData(Hospital hospital) {
        Department emergency = new Department("Akutten");
        emergency.addEmployee(new Employee("Odd Even", "Primtallet", ""));
        emergency.addEmployee(new Employee("Huppasahn", "DelFinito", ""));
        emergency.addEmployee(new Employee("Rigmor", "Mortis", ""));
        emergency.addEmployee(new GeneralPractitioner("Inco", "Gnito", ""));
        emergency.addEmployee(new Surgeon("Inco", "Gnito", ""));
        emergency.addEmployee(new Nurse("Nina", "Teknologi", ""));
        emergency.addEmployee(new Nurse("Ove", "Ralt", ""));
        emergency.addPatient(new Patient("Inga", "Lykke", ""));
        emergency.addPatient(new Patient("Ulrik", "Smål", ""));
        hospital.addDepartment(emergency);

        Department childrenPolyclinic = new Department("Barn poliklinikk");
        childrenPolyclinic.addEmployee(new Employee("Salti", "Kaffen", ""));
        childrenPolyclinic.addEmployee(new Employee("Nidel V.", "Elvefølger", ""));
        childrenPolyclinic.addEmployee(new Employee("Anton", "Nym", ""));
        childrenPolyclinic.addEmployee(new GeneralPractitioner("Gene", "Sis", ""));
        childrenPolyclinic.addEmployee(new Surgeon("Nanna", "Na", ""));
        childrenPolyclinic.addEmployee(new Nurse("Nora", "Toriet", ""));
        childrenPolyclinic.addPatient(new Patient("Hans", "Omvar", ""));
        childrenPolyclinic.addPatient(new Patient("Laila", "La", ""));
        childrenPolyclinic.addPatient(new Patient("Jøran", "Drebli", ""));
        hospital.addDepartment(childrenPolyclinic);

        return hospital;
    }
}
