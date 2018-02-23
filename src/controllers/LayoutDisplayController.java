package controllers;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * This class combines the layout with the views to support the layout-based views
 * @author Marceli Wac
 */
public class LayoutDisplayController {
    private Scene view;
    private Pane currentLayout;
    private Pane currentContent;
    private Pane currentLayoutContentPane;

    /**
     * initialise the controller with supplied views
     * @param content
     * @param layout
     */
    public LayoutDisplayController(Pane content, Pane layout) {
        this.currentContent = content;
        this.currentLayout = layout;
        this.bindContent();
    }

    /**
     * returns the combined view
     * @return
     */
    public Scene getView() {
        this.buildView();
        return this.view;
    }

    /**
     * binds the content space of layout file with the view that will be embedded in it
     * @throws IllegalArgumentException
     */
    private void bindContent() throws IllegalArgumentException {
        Pane p = (Pane) currentLayout.lookup("#content");
        if (p != null) {
            this.currentLayoutContentPane = p;
        } else {
            throw new IllegalArgumentException("Provided layout does not contain element with id 'content'.");
        }
    }

    /**
     * Joins the two components together
     */
    private void buildView() {
        this.currentLayoutContentPane.getChildren().setAll(currentContent);
        this.view = new Scene(currentLayout);
    }
}
