package controllers;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author Marceli Wac
 */


public class LayoutDisplayController {
    private Scene view;
    private Pane currentLayout;
    private Pane currentContent;
    private Pane currentLayoutContentPane;

    public LayoutDisplayController(Pane content, Pane layout) {
        this.currentContent = content;
        this.currentLayout = layout;
        this.bindContent();
    }

    public Scene getView() {
        this.buildView();
        return this.view;
    }

    private void bindContent() throws IllegalArgumentException {
        Pane p = (Pane) currentLayout.lookup("#content");
        if (p != null) {
            this.currentLayoutContentPane = p;
        } else {
            throw new IllegalArgumentException("Provided layout does not contain element with id 'content'.");
        }
    }

    private void buildView() {
        this.currentLayoutContentPane.getChildren().setAll(currentContent);
        this.view = new Scene(currentLayout);
    }
}
