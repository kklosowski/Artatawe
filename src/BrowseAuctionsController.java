import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrowseAuctionsController {
    private Scene view;
    private AuctionModel model;
    private Pane[] auctionPanes;
    private LayoutDisplayController ldc;
    private Pane auctionPaneScaffolding;

    public BrowseAuctionsController(Pane layout, Pane view){
        try{
            ldc = new LayoutDisplayController(layout, view);
            this.view = ldc.getView();
            //TODO move this to general loader
            auctionPaneScaffolding = FXMLLoader.load(getClass().getResource("/views/browsing_auctions.fxml"));
        }catch(Exception e){
            ErrorController ec = new ErrorController(e);
            this.view = ec.getView();
        }
    }

    public Scene getAllAuctions(){
        try{
            this.model = new AuctionModel();
            List<Auction> auctions = this.model.getAllAuctions();
            this.auctionPanes = new Pane[auctions.size()];
            //create auctions' panes
            for(int i = 0; i < auctions.size(); i++){
                Auction currAuction = auctions.get(i);
                Artwork currArtwork = currAuction.getArtwork();

                auctionPanes[i] = new AuctionPane(
                        getAuctionPaneScaffolding(),
                        currArtwork.getTitle(),
                        currArtwork.getDescription(),
                        currAuction.getCurrentPrice(),
                        currAuction.bidsLeft(),
                        currArtwork.getPrimaryPicture()
                );
            }
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

    private Pane getAuctionPaneScaffolding(){
        Pane p = this.auctionPaneScaffolding;
        return p;
    }

    //TODO remove this dummy method once done with testing
    public Scene getView(){
        return this.view;
    }
}
