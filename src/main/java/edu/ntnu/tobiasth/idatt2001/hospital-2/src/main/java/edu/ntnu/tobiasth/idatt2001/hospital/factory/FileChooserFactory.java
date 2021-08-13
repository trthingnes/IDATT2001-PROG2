package edu.ntnu.tobiasth.idatt2001.hospital.factory;

import javafx.stage.FileChooser;

/**
 * Generates {@link FileChooser} objects.
 * @author trthingnes
 */
public class FileChooserFactory {
    private FileChooserFactory() {}

    /**
     * Gets a {@link FileChooser} with the given title.
     *
     * @param title Window title to display.
     * @return FileChooser.
     */
    public static FileChooser getFileChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Comma Separated Values File", "*.csv");
        fileChooser.getExtensionFilters().add(filter);

        return fileChooser;
    }
}
