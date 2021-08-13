package edu.ntnu.tobiasth.idatt2001.hospital.factory;

import edu.ntnu.tobiasth.idatt2001.hospital.App;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Generates popup window {@link Stage} objects.
 * @author trthingnes
 */
public class PopupWindowFactory {
    private PopupWindowFactory() {}

    /**
     * Get a stage with the given title.
     *
     * @param title Window title to display.
     * @return Popup window stage.
     */
    public static Stage getPopupWindow(String title) {
        Stage window = new Stage();

        window.setTitle(title);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image(App.class.getResource("/img/logo.png").toString()));

        return window;
    }
}
