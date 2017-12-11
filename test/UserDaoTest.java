import artatawe.Address;
import artatawe.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kamil Klosowski
 * @project Artatawe
 * @since 11/12/2017
 */
class UserDaoTest {

    Address address = new Address("Swansea University", "Cefn Bryn Rhossili", "Singleton Park", "SWANSEA", "SA2 8PT", "UK");
    User user = new User("Kamil", "Klosowski", "kklosowski", "1323385659", address, "123.png");

    @Test
    void getAllUsers() {
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void insertUser() {
    }

    @Test
    void deleteUser() {
    }

}