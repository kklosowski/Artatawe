package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;

public class BrowseAuctionsController {
    private String type = "all";
    private final String activeStyle = "-fx-text-fill: #ffffff; -fx-background-color: #4285f4;";
    private final String inactiveStyle = "-fx-text-fill: #ffffff; -fx-background-color: #4285f4;";

    @FXML
    private Button paintingsFilterButton;

    @FXML
    private Button sculpturesFilterButton;

    @FXML
    private Button allFilterButton;

    @FXML
    private CheckBox onlyMineCheckbox;

    @FXML
    private void paintingsFilter(){
        this.type = "paintings";
        this.paintingsFilterButton.setStyle(activeStyle);
        this.sculpturesFilterButton.setStyle(inactiveStyle);
        this.allFilterButton.setStyle(inactiveStyle);
    }

    @FXML
    private void sculpturesFilter(){
        this.type = "sculptures";
        this.paintingsFilterButton.setStyle(inactiveStyle);
        this.sculpturesFilterButton.setStyle(activeStyle);
        this.allFilterButton.setStyle(inactiveStyle);

    }

    @FXML
    private void allFilter(){
        this.type = "all";
        this.paintingsFilterButton.setStyle(inactiveStyle);
        this.sculpturesFilterButton.setStyle(inactiveStyle);
        this.allFilterButton.setStyle(activeStyle);
    }

    @FXML
    private void onlyMine(){

    }

    private void getAuctions(){
        boolean onlyMine = this.onlyMineCheckbox.isSelected();

    }
}
