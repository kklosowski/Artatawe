package artatawe;

import dataAccessObjects.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shu testing
 * @since 1/12/2017
 */
public class BidTester {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        BidDao bidDao = new BidDao();
        ArtworkDao artworkDao = new ArtworkDao();
        AuctionDao auctionDao = new AuctionDao();
        AddressDao addressDao = new AddressDao();
        List<User> userList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        List<Artwork> artworkList = new ArrayList<>();
        List<Auction> auctionsList = new ArrayList<>();
        List<Bid> bidList = new ArrayList<>();

        try {
            addressList.add(new Address("7 Oaskwook Place", "Oakwood Pl", "", "Croydon", "CR0 3US", "UK"));
            addressList.add(new Address("Swansea University", "Cefn Bryn Rhossili", "Singleton Park", "SWANSEA", "SA2 8PT", "UK"));
            addressList.add(new Address("0/2 14 South Avenue", "", "", "PAISLEY", "PA2 7SP", "UK"));
            addressList.add(new Address("F D S", "F D S House", "3-5 Tammy Hall Street", "WAKEFIELD", "WF1 2SX", "UK"));
            addressList.add(new Address("L Seran", "Cook Lane", "North Stoke", "WALLINGFORD", "OX10 6BG", "UK"));
            addressList.add(new Address("Oxfam", "3 Bewley Court", "Great Boughton", "CHESTER", "CH3 5XY", "UK"));
            addressList.add(new Address("Oxford", "116A High Street", "", "GOSPORT", "PO12 1DU", "UK"));
            addressList.add(new Address("Sheilings", "10 Main Lane", "Croft", "WARRINGTON", "WA3 7EE", "UK"));
            addressList.add(new Address("Barton House", "Angersleigh", "", "TAUNTON", "TA3 7SY", "UK"));

            userList.add(new User("Shu Yu", "Goh", "shuyu6", "4757001800", addressList.get(0), "123.png"));
            userList.add(new User("Kamil", "Klosowski", "kklosowski", "1323385659", addressList.get(1), "123.png"));
            userList.add(new User("Morgan", "David", "MorganDavid", "5612835401", addressList.get(2), "123.png"));
            userList.add(new User("Marceli", "Wac", "marceliwac", "7357068589", addressList.get(3), "123.png"));
            userList.add(new User("Tereza", "Vladislavova Pashinska", "TerezaPashinska", "7404696626", addressList.get(4), "123.png"));
            userList.add(new User("Michael", "Lam", "randompasser", "1308387873", addressList.get(5), "123.png"));
            userList.add(new User("Sarette", "Derle", "sderlea", "2808326006", addressList.get(6), "123.png"));
            userList.add(new User("Maxie", "Mosley", "mmosleyc", "6541224536", addressList.get(7), "123.png"));
            userList.add(new User("Sadie", "Daskiewics", "sdaskiewicz0", "7207971936", addressList.get(8), "123.png"));
//remove the comment to insert users into database
//            for (int i = 0 ; i < addressList.size() ; i++){
//                userDao.insertUser(userList.get(i));
//            }
            List<String> noAdditionalImage = new ArrayList<>();
            artworkList.add(new Painting("Monalisa", "Probably the most famous painting in the world is Monalisa by Leonardo da Vinci. It is a portrait of a lady called Gherardini and is famous because the lady’s expression is indecipherable. This painting is currently displayed in Louvre, France.",
                    "Leonardo da Vinci", "123.jpg", 1517, 77, 53));
            artworkList.add(new Sculpture("VENUS DE MILO", "Also located in the Louvre, the Venus de Milo is also known as the Aphrodite of Milos and is thought to depict Aphrodite, the Greek goddess of love. The marble sculpture stands 6 feet 8 inches tall and is known for its missing arms. As any limbs were in peril of breaking off over time, its not uncommon for ancient sculpture to be missing their limbs. The world famous sculpture was found on the Greek island of Milos in 1820 by a peasant, who discovered it fractured into two pieces. ",
                    " Dali", "123.jpg", 1936, "marble ", 90, 203, 50,noAdditionalImage));
            artworkList.add(new Sculpture("DAVID BY DONATELLO", " Cast in bronze, Donatellos David is younger and more contemplative, having just slain Goliath. In fact, Donatello cleverly uses Goliaths head and Davids sword as supports for the structure. The sculpture caused a scandal at the time, as David is nude except for his boots, and was considered so naturalistic it was disturbing. ",
                    "Dontaello ", "123.jpg", 1430, "bronze", 83, 158, 68,noAdditionalImage));
            artworkList.add(new Painting("School of Athens", "Painted by Raphael, this painting contains pictures of famous philosophers such as Plato and Aristotle walking in the middle along with other philosophers on the sides. It is now located in the Vatican.",
                    "Raphael", "123.jpg", 1511, 500, 770));
            artworkList.add(new Painting("Night Watch", "",
                    " Rembrandt", "123.jpg", 1642, 363, 437));
            artworkList.add(new Painting("Beheading of Saint John the Baptist", "This painting by Caravaggio shows a realistic depiction of a murder moment in a prison. The gloom of the picture and the expressions of the onlookers make it a true classical masterpiece. It is displayed in St. John’s Cathedral in Valletta, Malta.",
                    "Caravaggio ", "123.jpg", 1608, 370, 520));
            artworkList.add(new Sculpture("Michelangelos David", "ature of the hero it represented, the statue soon came to symbolize the defense of civil liberties embodied in the Republic of Florence, an independent city-state threatened on all sides by more powerful rival states and by the hegemony of the Medici family. The eyes of David, with a warning glare, were turned towards Rome.[2] The statue was moved to the Galleria dell Accademia, Florence, in 1873, and later replaced at the original location by a replica.",
                    "Michelangelo", "123.jpg", 1501, "Marble", 250, 518, 123,noAdditionalImage));
            artworkList.add(new Sculpture("Spanish Horse I", "",
                    "Marie Ackers", "123.jpg", 2014, "Bronze ", 39.4, 42.2, 19.7,noAdditionalImage));
            artworkList.add(new Sculpture("Whispering Spirit", "This is a sculpture that Simon wanted to make ever since he planted the silver birch wood along the river at Sculpture by the Lakes in 2008. He was inspired to produce a sculpture that had an aural quality; one that would accentuate the noise of the wind through the trees and the birds singing. Whilst the front of the sculpture is a figurative piece, the back is shaped like a cone, narrowing to an opening in her mouth. If you please your ear to her lips the sound beyond is magnified. ",
                    "Simon Gudgeon", "123.jpg", 2008, "Bronze", 34.3, 25.6, 16.9,noAdditionalImage));
            artworkList.add(new Sculpture("Equu ", "This is an iron sculpture belonging to Equu series inspired into a horse head. The sculpture was finished in natural oxid.",
                    "Roberto Canduela", "123.jpg", 0, " Metal on Iron.", 21.7, 18.5, 11.8,noAdditionalImage));
            artworkList.add(new Painting("The Girl With a Pearl Earring", "The Girl With a Pearl Earring is often known as Dutch Monalisa because the expression on the girl’s face is hard to understand. This painting by Johannes Vermeer has her pearl earrings as the focal point.",
                    " Johannes Vermeer", "123.jpg", 1665, 44, 39));

            //remove the coomment to insert artwork into database
//            for (int i =0 ; i<artworkList.size();i++){
//                artworkDao.insertArtwork(artworkList.get(i));
//            }

            artworkList = artworkDao.getAllArtwork();
            System.out.println("hi " + ((Sculpture)artworkList.get(1)).getAdditionalPictures().size());
            for (int i = 0; i < artworkList.size(); i++) {
                auctionsList.add(new Auction(userList.get((int) Math.round(Math.random() * 8)), 10000, 2000, 8, artworkList.get(i)));
            }
// remove the comment to insert auction into database
//            for (int i=0 ; i<artworkList.size();i++) {
//                auctionDao.insertAuction(auctionsList.get(i));
//            }


            for (int i = 0; i < 15; i++) {
                bidList.add(new Bid(i, i * 350, new Timestamp(System.currentTimeMillis())));
            }
            //remove the comment to insert bid into database
//            for (int i=0; i<bidList.size(); i++) {
//                bidDao.insertBid(bidList.get(i),(int)(Math.random()*11));
//            }

// remove comment to insert favorite users
//            userDao.insertFavourite(1,2);
//            userDao.insertFavourite(1,3);
//            userDao.insertFavourite(1,4);
//            userDao.insertFavourite(1,5);
//            userDao.insertFavourite(1,6);

// remove comment to insert sculpture additional pic url
//            artworkDao.insertSculptureAdditionalPic(2,"123.jpg");
//            artworkDao.insertSculptureAdditionalPic(2,"1234.jpg");
//            artworkDao.insertSculptureAdditionalPic(2,"1235.jpg");
//            artworkDao.deleteSculptureAdditionalPic(2,"1235.jpg");


            User firstUser = userDao.getUser(1);
            System.out.println("favourite users for user 1 =" + firstUser.getFavouriteUsers().size());

            addressDao.getAddress(1);

        } catch (SQLException ex) {
            System.out.println("error sad sad " + ex.getMessage());
        }

    }
}
