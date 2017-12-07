import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author shu testing
 * @since   1/12/2017
 */
public class BidTester {
    public static void main(String[] args){
        BidDao bidDao = new BidDao();
        try {
            Bid bid = new Bid(1,30.00);
            bidDao.insertBid(bid,1);

        }catch (SQLException ex){
            System.out.println("error sad sad "+ex.getMessage());
        }

    }
}
