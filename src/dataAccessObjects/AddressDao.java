package dataAccessObjects;

import artatawe.Address;
import artatawe.DBUtils;
import artatawe.SQLiteSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A linking connection between address class and address table in database
 * @author Goh Shu Yu
 * @since 2/12/2017
 */
public class AddressDao {

    /**
     * Get the connection form the class - SQLiteSingleton.
     */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();

    /**
     * Address table name in database.
     */
    private final String ADDRESS_TABLE_NAME = "address";

    /**
     * Retrieve specific address by user id from database.
     *
     * @param userId The user's id.
     * @return Return user's address if the address is found if not return null.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public Address getAddress(int userId) throws SQLException {
        String searchAddressQuery = String.format("SELECT * FROM %s WHERE user_id = %d", ADDRESS_TABLE_NAME, userId);
        ResultSet rs = connection.query(searchAddressQuery);

        if (rs.next()) {
            return DBUtils.constructAddressFromRS(rs);
        }
        return null;
    }

    /**
     * Update address by user id in database.
     *
     * @param address New address that required to update the database.
     * @param user_id The user's is that requested to update address.
     * @return If update successfully it will return any integer that is not 0, if unable to update it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int updateAddress(Address address, int user_id) throws SQLException {
        String updateQuery = String.format("UPDATE %s " +
                        "SET address_line1 = '%s', " +
                        "address_line2 = '%s', " +
                        "address_line3 = '%s', " +
                        "city ='%s', " +
                        "postcode = '%s', " +
                        "country = '%s' " +
                        "WHERE user_id = %d",
                ADDRESS_TABLE_NAME,
                address.getAddress1(),
                address.getAddress2(),
                address.getAddress3(),
                address.getCity(),
                address.getPostcode(),
                address.getCountry(),
                user_id);
        return connection.insert(updateQuery);
    }

    /**
     * Delete specific address by user id from database.
     *
     * @param userId The user's id that request to delete address.
     * @return If delete successfully it will return any integer except 0, if unable to update it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int deleteAddress(int userId) throws SQLException {
        String deleteQuery = String.format("DELETE FROM %s WHERE user_id = %d",
                ADDRESS_TABLE_NAME, userId);
        return connection.insert(deleteQuery);
    }

    /**
     * Insert new address into database.
     *
     * @param address User's address.
     * @param userId  User's id.
     * @return If insert successfully it will return any integer except 0, if unable to update it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int insertAddress(Address address, int userId) throws SQLException {
        String insertQeury = String.format("INSERT INTO %s " +
                        "(address_line1,address_line2,address_line3,city,postcode,country,user_id) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s',%d)",
                ADDRESS_TABLE_NAME,
                address.getAddress1(),
                address.getAddress2(),
                address.getAddress3(),
                address.getCity(),
                address.getPostcode(),
                address.getCountry(),
                userId);
        return connection.insert(insertQeury);
    }
}
