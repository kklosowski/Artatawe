package artatawe;

import java.sql.Timestamp;
import java.util.List;

class FeedController {
private int userId;
private Timestamp lastLogin;

	public FeedController(int userId, Timestamp lastLogin){
		this.userId = userId;
		this.lastLogin = lastLogin;
	}

	public artatawe.Auction[] getAllAuctions(boolean paintings, boolean sculptures){
		artatawe.Auction[] auctions = new artatawe.Auction[0];
		return auctions;
	}

	public artatawe.Auction[] getNewAuctions(boolean paintings, boolean sculptures){
		artatawe.Auction[] auctions = new artatawe.Auction[0];
		return auctions;
	}

	public artatawe.Auction[] getNewAuctionsUserParticipatesIn(boolean paintings, boolean sculptures){
		artatawe.Auction[] auctions = new artatawe.Auction[0];
		return auctions;
	}

	public artatawe.Auction[] getMyAuctions(boolean paintings, boolean sculptures){
		artatawe.Auction[] auctions = new artatawe.Auction[0];
		return auctions;
	}

	public artatawe.Auction[] getAuctionsByQuery(boolean paintings, boolean sculptures, String query){
		artatawe.Auction[] auctions = new artatawe.Auction[0];
		return auctions;
	}
}
