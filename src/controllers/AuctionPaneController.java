package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AuctionPaneController{

    @FXML
    private Pane mainPane;

    @FXML
    private Text title;

    @FXML
    private Text type;

    @FXML
    private Text currentPrice;

    @FXML
    private Text bidsLeft;

    @FXML
    private Text description;

    @FXML
    private ImageView thumbnail;

    @FXML
    public void initialize(){
    }

    public void setTitle(String s){
        this.title.setText(s);
    }

    public void setDescription(String s){
        this.description.setText(s);
    }

    public void setType(String s){
        this.type.setText(s);
    }

    public void setCurrentPrice(String s){
        this.currentPrice.setText(s);
    }

    public void setBidsLeft(String s){
        this.bidsLeft.setText(s);
    }

}
