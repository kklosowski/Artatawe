import artatawe.*;
import dataAccessObjects.AuctionDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Kamil Klosowski
 * @project Artatawe
 * @since 08/12/2017
 */
class AuctionDaoTest {

    Address address = new Address("Swansea University", "Cefn Bryn Rhossili", "Singleton Park", "SWANSEA", "SA2 8PT", "UK");
    User user = new User("Kamil", "Klosowski", "kklosowski", "1323385659", address, "123.png");
    Artwork artwork = new Painting("Monalisa", "Probably the most famous painting in the world is Monalisa by Leonardo da Vinci. It is a portrait of a lady called Gherardini and is famous because the lady’s expression is indecipherable. This painting is currently displayed in Louvre, France.",
            "Leonardo da Vinci", "123.jpg", 1517, 77, 53);
    Auction auction = new Auction(user, 10000, 2000, 8, artwork);

    @Test
    void getAllAuctions() {
        AuctionDao auctionDao = new AuctionDao();
        List<Auction> auctions = new ArrayList<>();
        try {
            auctions = auctionDao.getAllAuctions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(auctions.stream().allMatch(Objects::nonNull));
    }

    @Test
    void getAuction() {

    }

    @Test
    void updateAuction() {

    }

    @Test
    void insertAuction() {

        AuctionDao auctionDao = new AuctionDao();
        int result = 0;
        try {
            result = auctionDao.insertAuction(auction);
            auction.setAuctionId(auctionDao.getLastId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(1, result);
    }

    @Test
    void deleteAuction() {
        AuctionDao auctionDao = new AuctionDao();
        int result = 0;
        try {
            auction.setAuctionId(auctionDao.getLastId());
            result = auctionDao.deleteAuction(auction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1, result);
    }

}