package edu.ntnu.tobiasth.idatt2001.hospital.controller;

import edu.ntnu.tobiasth.idatt2001.hospital.App;
import edu.ntnu.tobiasth.idatt2001.hospital.dao.PatientDAO;
import edu.ntnu.tobiasth.idatt2001.hospital.factory.*;
import edu.ntnu.tobiasth.idatt2001.hospital.util.CSVHandler;
import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.css.Styleable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Controls the main application scene.
 * @author trthingnes
 */
public class AppController {
    private final PatientDAO patientDAO = new PatientDAO(Persistence.createEntityManagerFactory("pu-derby").createEntityManager());

    @FXML
    private TableView<Patient> patientTable;

    /**
     * Initializes the application scene. Runs on load.
     */
    @FXML
    public void initialize() {
        // Initialize table
        TableColumn<Patient, String> pidNumberColumn = TableColumnFactory.getTableColumn("Personal ID number", "pidNumber");
        TableColumn<Patient, String> firstNameColumn = TableColumnFactory.getTableColumn("First name", "firstName");
        TableColumn<Patient, String> lastNameColumn = TableColumnFactory.getTableColumn("Last name", "lastName");
        TableColumn<Patient, String> doctorNameColumn = TableColumnFactory.getTableColumn("Doctor name", "doctorName");
        patientTable.getColumns().addAll(List.of(pidNumberColumn, firstNameColumn, lastNameColumn, doctorNameColumn));
        patientTable.setItems(App.getPatientList());
    }

    /**
     * Runs when a button or menu item is clicked.
     *
     * The method uses the style ID of the clicked item to determine what to do.
     * All buttons and menu items have a style ID matching a method.
     *
     * @param event Click event with info about the target.
     */
    @FXML
    public void onClick(Event event) {
        Styleable target = (Styleable) event.getTarget();

        switch(target.getId()) {
            case "add" -> addPatient();
            case "remove" -> removePatient();
            case "edit" -> editPatient();
            case "import_db" -> readFromDB();
            case "import_csv" -> readFromCSV();
            case "export_db" -> writeToDB();
            case "export_csv" -> writeToCSV();
            case "exit" -> showExitDialog();
            case "about" -> showAboutDialog();
            default -> System.err.printf("The action for '%s' has not been added yet.%n", target.getId());
        }
    }

    /**
     * Shows the user an input window and add a new patient with the given data.
     */
    private void addPatient() {
        try {
            Stage popupWindow = PopupWindowFactory.getPopupWindow("Add patient");
            FXMLLoader loader = FXMLLoaderFactory.getFXMLLoader("input");
            popupWindow.setScene(new Scene(loader.load()));
            popupWindow.showAndWait();

            InputController controller = loader.getController();
            Patient newPatient = controller.getSubmittedPatient();
            App.addPatient(newPatient);
        } catch (IOException | NumberFormatException e) {
            String dialogTitle = "Add patient failed";
            String dialogContent = String.format("Unable to add patient.\n(%s)", e.getMessage());
            DialogFactory.getOKDialog(dialogTitle, dialogContent).show();
        }
    }

    /**
     * Shows the user a prefilled input window and updates the selected patient with the given data.
     *
     * This method requires a patient to be selected in the table view.
     */
    private void editPatient() {
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if(Objects.isNull(selectedPatient)) {
            DialogFactory.getOKDialog("No patient selected", "Please select a patient to edit.").show();
            return;
        }

        try {
            Stage popupWindow = PopupWindowFactory.getPopupWindow("Edit patient");
            FXMLLoader loader = FXMLLoaderFactory.getFXMLLoader("input");
            popupWindow.setScene(new Scene(loader.load()));

            InputController controller = loader.getController();
            controller.setPatientData(selectedPatient);
            popupWindow.showAndWait();

            Patient editedPatient = controller.getSubmittedPatient();
            App.removePatient(selectedPatient);
            App.addPatient(editedPatient);
        } catch (IOException e) {
            String dialogTitle = "Edit patient failed";
            String dialogContent = String.format("Unable to save patient.\n(%s)", e.getMessage());
            DialogFactory.getOKDialog(dialogTitle, dialogContent).show();
        }
    }

    /**
     * Shows the user a confirm dialog, and deletes the selected patient on confirmation.
     *
     * This method requires a patient to be selected in the table view.
     */
    private void removePatient() {
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if(Objects.isNull(selectedPatient)) {
            DialogFactory.getOKDialog("No patient selected", "Please select a patient to delete.").show();
            return;
        }

        String dialogTitle = "Remove patient?";
        String dialogContent = String.format("Are you sure you want to remove '%s, %s'?", selectedPatient.getFirstName(), selectedPatient.getLastName());
        Dialog<ButtonType> dialog = DialogFactory.getYesNoDialog(dialogTitle, dialogContent);
        dialog.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(r -> App.removePatient(selectedPatient));
    }

    /**
     * Shows the user a confirm dialog, and exits the application on confirmation.
     */
    private void showExitDialog() {
        String dialogTitle = "Quit?";
        String dialogContent = "Do you want to close the application?";
        Dialog<ButtonType> dialog = DialogFactory.getYesNoDialog(dialogTitle, dialogContent);
        dialog.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(r -> Platform.exit());
    }

    /**
     * Shows the user a file selection dialog, and attempts to load the selected CSV file.
     */
    private void readFromCSV() {
        String dialogTitle = null;
        String dialogContent = null;

        try {
            File file = FileChooserFactory.getFileChooser("Select file to import").showOpenDialog(App.getStage());
            List<Patient> patientList = CSVHandler.readCSV(Objects.requireNonNull(file).toURI());
            int skipped = 0;
            for(Patient patient : patientList) {
                try {
                    App.addPatient(patient);
                } catch(NumberFormatException e) {
                    skipped++;
                }
            }
            dialogTitle = "CSV import successful";
            dialogContent = String.format("Successfully imported %s patients.", patientList.size() - skipped);
        }
        catch(NullPointerException e) {
            dialogTitle = "CSV import failed";
            dialogContent = "File selection was cancelled.";
        }
        catch(IOException e) {
            dialogTitle = "CSV import failed";
            dialogContent = String.format("Unable to read patients from file.\n(%s)", e.getMessage());
        }
        finally {
            DialogFactory.getOKDialog(dialogTitle, dialogContent).show();
        }
    }

    /**
     * Attempt to load patients from database.
     */
    private void readFromDB() {
        String dialogTitle = null;
        String dialogContent = null;

        try {
            List<Patient> patientList = patientDAO.getAll().stream().filter(
                // Only add patients that do not already exist
                dbPatient -> App.getPatientList().stream().noneMatch(patient -> {
                    if(Objects.isNull(patient)) { return false; }
                    return patient.getPidNumber() == dbPatient.getPidNumber();
                })
            ).collect(Collectors.toList());

            for(Patient patient : patientList) {
                App.addPatient(patient);
            }

            dialogTitle = "Database load successful";
            dialogContent = String.format("Successfully loaded %s patients.", patientList.size());
        }
        catch (Exception e) {
            dialogTitle = "Database load failed";
            dialogContent = String.format("Unable to load patients from database.\n(%s)", e.getMessage());
        }
        finally {
            DialogFactory.getOKDialog(dialogTitle, dialogContent).show();
        }
    }

    /**
     * Shows the user a file selection dialog, and attempts to save to the selected CSV file.
     */
    private void writeToCSV() {
        String dialogTitle = null;
        String dialogContent = null;

        try {
            if(App.getPatientList().isEmpty()) {
                throw new IllegalArgumentException("Cannot write empty list to file.");
            }

            File file = FileChooserFactory.getFileChooser("Select export location").showSaveDialog(App.getStage());
            CSVHandler.writeCSV(Objects.requireNonNull(file).toURI(), App.getPatientList());

            dialogTitle = "CSV export successful";
            dialogContent = String.format("Successfully exported %s patients.", App.getPatientList().size());
        }
        catch(NullPointerException e) {
            dialogTitle = "CSV export failed";
            dialogContent = "File selection was cancelled.";
        }
        catch(IllegalArgumentException | IOException e) {
            dialogTitle = "CSV export failed";
            dialogContent = String.format("Unable to write patients to file.\n(%s)", e.getMessage());
        }
        finally {
            DialogFactory.getOKDialog(dialogTitle, dialogContent).show();
        }
    }

    /**
     * Attempts to save patients to database.
     */
    private void writeToDB() {
        AtomicReference<String> dialogTitle = new AtomicReference<>("Database export succeeded");
        AtomicReference<String> dialogContent = new AtomicReference<>(String.format("Successfully exported %s patients.", App.getPatientList().size()));

        // Empty database
        try { patientDAO.deleteAll(); } catch (Exception ignored) {}

        App.getPatientList().forEach(patient -> {
            try {
                patientDAO.createOrUpdate(patient);
            }
            catch(NullPointerException ignored) {}
            catch(Exception e) {
                dialogTitle.set("Database export incomplete");
                dialogContent.set(String.format("One or more patients failed to export.\n(%s)", e.getMessage()));
            }
        });

        DialogFactory.getOKDialog(dialogTitle.get(), dialogContent.get()).show();
    }

    /**
     * Shows the user an about dialog.
     */
    private void showAboutDialog() {
        String dialogTitle = "About";
        String dialogContent = "© 2021 Tobias Rødahl Thingnes";
        Dialog<ButtonType> aboutDialog = DialogFactory.getOKDialog(dialogTitle, dialogContent);
        aboutDialog.setHeaderText("Patient register\nv. 2.0-SNAPSHOT");
        aboutDialog.show();
    }
}
