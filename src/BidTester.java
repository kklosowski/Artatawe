import java.sql.SQLException;

/**
 *
 * @author shu testing
 * @since   1/12/2017
 */
public class BidTester {
    public static void main(String[] args){
        UserDao userDao = new UserDao();
//        BidDao bidDao = new BidDao();
        try {
            Address address = new Address("line 1","ine 2","","city","SA2 PT","UK");
            User user = new User("tester","test","test123","0103265521",address);
            userDao.insertUser(user);
//            Bid bid = new Bid(1,30.00);
//            bidDao.insertBid(bid,1);

        }catch (SQLException ex){
            System.out.println("error sad sad "+ex.getMessage());
        }

    }
}
