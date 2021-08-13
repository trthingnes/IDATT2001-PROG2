package edu.ntnu.tobiasth.idatt2001.hospital.factory;

import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Generates {@link Node} elements.
 * @author trthingnes
 * @deprecated This class is unused but required by the assignment. Please use FXML structure to add GUI elements.
 */
@Deprecated(forRemoval=false)
public class NodeFactory {
    private NodeFactory() {}

    public static Node getNode(NodeType type) {
        switch(type) {
            case MENUBAR -> {
                return new MenuBar();
            }

            case TOOLBAR -> {
                return new ToolBar();
            }

            case BORDERPANE -> {
                return new BorderPane();
            }

            case VBOX -> {
                return new VBox();
            }

            case TABLEVIEW -> {
                return new TableView<>();
            }

            default -> {
                return null;
            }
        }
    }

    public enum NodeType {
        MENUBAR, TOOLBAR, BORDERPANE, VBOX, TABLEVIEW;
    }
}
