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

    public BrowseAuctionsController(Pane layout, Pane view){
        try{
            ldc = new LayoutDisplayController(layout, view);
            this.view = ldc.getView();
        }catch(Exception e){
            ErrorController ec;
            if(e.getMessage() == null){
                ec = new ErrorController(e);
            }else{
                ec = new ErrorController(e.getMessage());
            }
            this.view = ec.getView();
        }
    }

    public void getAllAuctions(){
        try{
            this.model = new AuctionModel();
            List<Auction> auctions = this.model.getAllAuctions();
            this.auctionPanes = new Pane[auctions.size()];
            //create auctions' panes
            for(int i = 0; i < auctions.size(); i++){
                Auction currAuction = auctions.get(i);
                Artwork currArtwork = currAuction.getArtwork();
                auctionPanes[i] = new AuctionPane(
                        currArtwork.getTitle(),
                        currAuction.getCurrentPrice(),
                        currAuction.bidsLeft(),
                        currArtwork.getPrimaryPicture()
                );
            }
            for(Pane ap : auctionPanes){
                VBox auctionsTarget = (VBox) this.view.lookup("#auctions");
                auctionsTarget.getChildren().add(ap);
            }
        }catch(Exception e){
            ErrorController ec;
            if(e.getMessage() == null){
                ec = new ErrorController(e);
            }else{
                ec = new ErrorController(e.getMessage());
            }
            this.view = ec.getView();
        }
    }

    public Scene getView(){
        return this.view;
    }
}
