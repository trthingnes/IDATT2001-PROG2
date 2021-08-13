package edu.ntnu.tobiasth.idatt2001.hospital.util;

import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Handles CSV files.
 * @author trthingnes
 */
public class CSVHandler {
    private static final String splitChar = ";";

    private CSVHandler() {}

    /**
     * Attempts to read a list of {@link Patient} objects from the given CSV.
     *
     * @param fileURI Source file.
     * @return Patient list.
     * @throws IOException If file read fails.
     */
    public static List<Patient> readCSV(URI fileURI) throws IOException {
        ArrayList<Patient> patientList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileURI))) {
            String[] columnNames = br.readLine().split(splitChar);

            br.lines().forEach(line -> {
                /*
                The reason to use HashMap here is so that the order of the data in the CSV
                is irrelevant. As long as all required columns are in the file the data
                is read correctly, regardless of the order of the columns. Files with to much
                data can also be loaded without problem.
                 */
                HashMap<String, String> patientData = new HashMap<>();
                String[] lineData = line.split(splitChar);

                for(int i = 0; i < lineData.length; i++) {
                    patientData.put(columnNames[i], lineData[i]);
                }

                try {
                    patientList.add(new Patient(
                            patientData.get("pidNumber"),
                            patientData.get("firstName"),
                            patientData.get("lastName"),
                            patientData.get("doctorName"))
                    );
                }
                catch(IllegalArgumentException ignored) {}
            });
        }

        return patientList;
    }

    /**
     * Attempts to write a list of {@link Patient} objects to the given CSV.
     *
     * @param fileURI Target file.
     * @param patientList Patient list.
     * @throws IOException If file write fails.
     */
    public static void writeCSV(URI fileURI, List<Patient> patientList) throws IOException {
        String[] columnNames = {"pidNumber", "firstName", "lastName", "doctorName"};
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileURI))) {
            bw.write(String.join(splitChar, columnNames));
            bw.newLine();

            patientList.forEach(patient -> {
                String[] patientData = {
                        String.valueOf(patient.getPidNumber()),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getDoctorName()
                };

                try {
                    bw.write(String.join(splitChar, patientData));
                    bw.newLine();
                } catch (IOException ignored) {}
            });
        }
    }
}
