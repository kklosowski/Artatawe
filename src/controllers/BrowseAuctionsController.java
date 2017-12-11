package controllers;

public class BrowseAuctionsController {

    /*
    public Scene getAllAuctions(){
        try{
            this.model = new AuctionModel();
            List<Auction> auctions = this.model.getAllAuctions();
            this.auctionPanes = new Pane[auctions.size()];
            //create auctions' panes
            for(int i = 0; i < auctions.size(); i++){
                Auction currAuction = auctions.get(i);
                Artwork currArtwork = currAuction.getArtwork();


                AuctionPane ap = FXMLLoader.load(getClass().getResource("/views/browse_auctions.fxml"));

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
