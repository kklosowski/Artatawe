package artatawe;

import java.sql.Timestamp;

class FeedController {
    private int userId;
    private Timestamp lastLogin;

    public FeedController(int userId, Timestamp lastLogin) {
        this.userId = userId;
        this.lastLogin = lastLogin;
    }

    public Auction[] getAllAuctions(boolean paintings, boolean sculptures) {
        Auction[] auctions = new Auction[0];
        return auctions;
    }

    public Auction[] getNewAuctions(boolean paintings, boolean sculptures) {
        Auction[] auctions = new Auction[0];
        return auctions;
    }

    public Auction[] getNewAuctionsUserParticipatesIn(boolean paintings, boolean sculptures) {
        Auction[] auctions = new Auction[0];
        return auctions;
    }

    public Auction[] getMyAuctions(boolean paintings, boolean sculptures) {
        Auction[] auctions = new Auction[0];
        return auctions;
    }

    public Auction[] getAuctionsByQuery(boolean paintings, boolean sculptures, String query) {
        Auction[] auctions = new Auction[0];
        return auctions;
    }
}
