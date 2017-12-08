import java.sql.SQLException;

/**
 *
 * @author shu testing
 * @since   1/12/2017
 */
public class BidTester {
    public static void main(String[] args){
        UserDao userDao = new UserDao();
        BidDao bidDao = new BidDao();
        ArtworkDao artworkDao = new ArtworkDao();

        try {
            User user = userDao.getUser(2);
//            Sculpture sculpture = new Sculpture("scupture 2","description here 2222 " ," artist 2","sculpture.jpg",2017,"amo",50,30,60);
//            Painting painting = new Painting("painting ","i am painting description, sosososososososo... nothing to say" ," artist of a painting","2.jpg",2017,50,60);
//            artworkDao.insertArtwork(sculpture);
//            artworkDao.insertArtwork(painting);
            Artwork artwork = artworkDao.getArtwork(1);
            System.out.println("artwork " +artwork.getArtist());
            //            Artwork artwork = artworkDao.getArtwork(1);
//

//            Bid bid = new Bid(1,30.00);
//            bidDao.insertBid(bid,1);

        }catch (SQLException ex){
            System.out.println("error sad sad "+ex.getMessage());
        }

    }
}
//            Address address = new Address("line 1","ine 2","","city","SA2 PT","UK");
//            User user = new User("tester","test","test123","0103265521",address);
//            userDao.insertUser(user);
