import artatawe.Address;
import dataAccessObjects.AddressDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kamil Klosowski
 * @project Artatawe
 * @since 08/12/2017
 */
class AddressDaoTest {

    @Test
    void insertAddress() {
        AddressDao addressDao = new AddressDao();
        int result = 0;
        Address address = new Address("99 Test Avenue",
                "Testmill",
                "Test",
                "Testville",
                "SA99TT",
                "Testland");
        try {
            result = addressDao.insertAddress(address, 9999);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1, result);
    }

    @Test
    void getAddress() {
        AddressDao addressDao = new AddressDao();
        Address address = null;
        try {
            address = addressDao.getAddress(9999);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals("99 Test Avenue", address.getAddress1());
        assertEquals("Testmill", address.getAddress2());
        assertEquals("Test", address.getAddress3());
        assertEquals("Testville", address.getCity());
        assertEquals("SA99TT", address.getPostcode());
        assertEquals("Testland", address.getCountry());
    }

    @Test
    void updateAddress() {
        AddressDao addressDao = new AddressDao();
        int result = 0;
        Address address = new Address("99 Test Avenue Update",
                "TestmillUpdate",
                "TestUpdate",
                "Testville Update",
                "SA99TT",
                "TestlandUpdate");

        try {
            result = addressDao.updateAddress(address, 9999);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(1, result);
    }

    @Test
    void deleteAddress() {
        AddressDao addressDao = new AddressDao();
        int result = 0;
        try {
            result = addressDao.deleteAddress(9999);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(1, result);
    }

}