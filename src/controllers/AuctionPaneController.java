package controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AuctionPaneController {

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
