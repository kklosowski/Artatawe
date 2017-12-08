import java.sql.SQLException;
import java.util.List;

public class AuctionModel {
    private AuctionDao ad;

    public AuctionModel(){
        ad = new AuctionDao();
    }

    public List<Auction> getAllAuctions() throws SQLException{
        try{
            return ad.getAllAuctions();
        }catch(SQLException e){
            throw new SQLException("Could not fetch data from the database");
        }
    }
}
