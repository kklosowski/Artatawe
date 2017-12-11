package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author Marceli Wac
 */


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
    private Text currentAuctionId;

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

    @FXML
    public void loadAuction(){
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.AUCTION_URL, ViewLoader.LAYOUT_URL);
        Scene s = (Scene) l.getView();
        ((Text) s.lookup("#mainPane").lookup("#vbox1").lookup("#hbox1").lookup("#vbox11").lookup("#title")).setText(title.getText());
        ((Text) s.lookup("#mainPane").lookup("#vbox1").lookup("#hbox1").lookup("#vbox11").lookup("#type")).setText(type.getText());
        ((Text) s.lookup("#mainPane").lookup("#vbox1").lookup("#hbox5").lookup("#vbox4").lookup("#description")).setText(description.getText());
        ((Text) s.lookup("#mainPane").lookup("#vbox1").lookup("#hbox5").lookup("#vbox4").lookup("#hbox6").lookup("#currentPrice")).setText(currentPrice.getText());
        ((Text) s.lookup("#mainPane").lookup("#vbox1").lookup("#hbox5").lookup("#vbox4").lookup("#hbox7").lookup("#bidsLeft")).setText(bidsLeft.getText());

        Stage ss = (Stage) this.title.getScene().getWindow();
        SessionStorage.sessionData.put("currentAuctionId", this.currentAuctionId.getText());
        ss.setScene(s);

    }

}
