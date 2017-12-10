package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.*;

import java.util.List;

public class BrowseAuctionsController extends ViewController{

    private final String CONTENT_FXML_URL = "/views/browse_auctions.fxml";
    private final String LAYOUT_FXML_URL = "/views/_layout.fxml";

    public BrowseAuctionsController(){
        loadViewController(CONTENT_FXML_URL, LAYOUT_FXML_URL);
    }

    /*
    public Scene getAllAuctions(){
        try{
            this.model = new AuctionModel();
            List<artatawe.Auction> auctions = this.model.getAllAuctions();
            this.auctionPanes = new Pane[auctions.size()];
            //create auctions' panes
            for(int i = 0; i < auctions.size(); i++){
                artatawe.Auction currAuction = auctions.get(i);
                artatawe.Artwork currArtwork = currAuction.getArtwork();


                artatawe.AuctionPane ap = FXMLLoader.load(getClass().getResource("/views/browse_auctions.fxml"));

                auctionPanes[i] = ap;
                ap.setAttributes(
                        currArtwork.getTitle(),
                        currArtwork.getDescription(),
                        currAuction.getCurrentPrice(),
                        currAuction.bidsLeft(),
                        currArtwork.getPrimaryPicture()
                );
            }
            this.view.getRoot().applyCss();
            VBox auctionsTarget = (VBox) this.view.lookup("#auctions");
            if(auctionsTarget == null){
                throw new IllegalArgumentException("The auction view does not contain container to display auctions in");
            }
            for(Pane ap : auctionPanes){
                auctionsTarget.getChildren().add(ap);
            }
        }catch(Exception e){
            ErrorController ec = new ErrorController(e);
            this.view = ec.getView();
        }finally{
            return this.view;
        }
    }

    */
}
