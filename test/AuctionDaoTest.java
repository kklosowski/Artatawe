import org.junit.jupiter.api.Test;

import artatawe.*;
import dataAccessObjects.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamil Klosowski
 * @project Artatawe
 * @since 08/12/2017
 */
class AuctionDaoTest {

    @Test
    void getAllAuctions() {
        AuctionDao auctionDao = new AuctionDao();
        List<Auction> auctions = new ArrayList<>();
        try {
            auctions = auctionDao.getAllAuctions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAuction() {
    }

    @Test
    void updateAuction() {
    }

    @Test
    void insertAuction() {
    }

    @Test
    void deleteAuction() {
    }

}