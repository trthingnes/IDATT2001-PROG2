package edu.ntnu.tobiasth.idatt2001.hospital.controller;

import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;
import edu.ntnu.tobiasth.idatt2001.hospital.factory.DialogFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controls the patient input scene.
 * @author trthingnes
 */
public class InputController {
    @FXML
    private TextField pidNumberField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField doctorNameField;

    private Patient submittedPatient;

    /**
     * Validates and saves the data to the submittedPatient object.
     */
    @FXML
    public void onSubmitClicked() {
        String pidNumber = pidNumberField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String doctorName = doctorNameField.getText();

        Stage stage = (Stage) pidNumberField.getScene().getWindow();
        try {
            submittedPatient = new Patient(pidNumber, firstName, lastName, doctorName);
            stage.close();
        }
        catch(IllegalArgumentException e) {
            String dialogTitle = "Submission failed";
            String dialogContent = String.format("Unable to save.\n(%s)", e.getMessage());
            DialogFactory.getOKDialog(dialogTitle, dialogContent).show();
        }
    }

    /**
     * Prefills the input field with data from the given patient.
     *
     * @param patient Patient to get data from.
     */
    public void setPatientData(Patient patient) {
        pidNumberField.setText(String.valueOf(patient.getPidNumber()));
        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        doctorNameField.setText(patient.getDoctorName());
    }

    /**
     * Gets the submitted patient.
     *
     * Used by the parent controller to get the patient data.
     *
     * @return Validated patient.
     */
    public Patient getSubmittedPatient() {
        return submittedPatient;
    }
}
