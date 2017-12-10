package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.DataModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class ViewController {
    private Scene view;
    private Scene errorView;
    public Pane content;
    private Pane layout;
    private DataModel model;


    public void loadViewController(String contentFxmlUrl) {
        this.errorView = null;
        this.loadContent(contentFxmlUrl);
    }

    public void loadViewController(String contentFxmlUrl, String layoutFxmlUrl) {
        this.errorView = null;
        this.loadContent(contentFxmlUrl);
        this.loadLayout(layoutFxmlUrl);
    }

    public Scene getView() {
        if (this.errorView == null) {
            this.buildView();
            return this.view;
        } else {
            return this.errorView;
        }
    }

    private void loadContent(String FxmlUrl) {
        try {
            this.content = FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e){
            e.printStackTrace();
            //TODO implement ErrorController
            //ErrorController ec = new ErrorController(e);
            //this.errorView = ec.getView();
        }
    }

    private void loadLayout(String FxmlUrl) {
        try {
            this.layout = FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e) {
            //ErrorController ec = new ErrorController(e);
            //this.errorView = ec.getView();
        }
    }

    protected void setContent(Pane newContent) {
        this.content = newContent;
    }

    protected void setLayout(Pane newLayout) {
        this.layout = newLayout;
    }

    protected void setModel(DataModel newModel) {
        this.model = newModel;
    }

    protected Pane getContent(){
        return this.content;
    }

    protected Stage getCurrentStage(){
        if(this.view != null){
            return (Stage) this.view.getWindow();
        }else{
            return null;
        }
    }

    private void buildView() {
        if (this.content == null) {
            throw new IllegalStateException("The content of the current view is not set");
        }
        if (this.layout == null) {
            this.view = new Scene(content);
        } else {
            LayoutDisplayController ldc = new LayoutDisplayController(this.content, this.layout);
            this.view = ldc.getView();
        }

    }

}
