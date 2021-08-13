package edu.ntnu.tobiasth.idatt2001.hospital;

import edu.ntnu.tobiasth.idatt2001.hospital.factory.FXMLLoaderFactory;
import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Application start class.
 * @author trthingnes
 */
public class App extends Application {
    private static final ObservableList<Patient> patientList = FXCollections.observableArrayList();
    private static Stage stage;

    public static void addPatient(Patient patient) {
        if(App.patientList.stream().anyMatch(p -> p.getPidNumber() == patient.getPidNumber())) {
            throw new NumberFormatException("A person with that personal ID number already exists");
        }

        patientList.add(patient);
    }

    public static void removePatient(Patient patient) {
        patientList.remove(patient);
    }

    public static ObservableList<Patient> getPatientList() {
        return patientList;
    }

    /**
     * Gets the main application stage.
     *
     * @return Main stage.
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * Launches the application.
     *
     * @param stage Stage passed on from JavaFX.
     * @throws Exception If launch fails.
     */
    @Override
    public void start(Stage stage) throws Exception {
        App.stage = stage;

        Scene scene = new Scene(FXMLLoaderFactory.getFXMLLoader("app").load());
        stage.setScene(scene);
        stage.setTitle("Patient register");
        stage.getIcons().add(new Image(App.class.getResource("/img/logo.png").toString()));
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.centerOnScreen();
        stage.show();
    }
}
