import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author  Kamil Klosowski
 * @since   1/12/2017
 */
public class AddressDao {
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    private final String ADDRESS_TABLE_NAME = "address";

    public Address getAddress(int userId) throws SQLException{
        String searchAddressQuery = "SELECT * FROM "+ ADDRESS_TABLE_NAME+" WHERE user_id =" + userId;
        ResultSet rs = connection.query(searchAddressQuery);

        if (rs.next()) {
            return DBUtils.constructAddressFromRS(rs);
        }
        return null;
    }

    public void updateAddress(Address address, int user_id) throws SQLException{
        String updateQuery = "UPDATE "+ADDRESS_TABLE_NAME+" SET address_line1 = '"+ address.getAddress1()
                + "', address_line2 = '"+ address.getAddress2()+ "' , address_line3 = '"+ address.getAddress3()
                + "', city ='" + address.getCity()+ "' , postcode = '"+ address.getPostcode()
                + "', country = '"+address.getCountry() + "' WHERE user_id = "+user_id;
        System.out.println("update address query " + updateQuery);
        connection.insert(updateQuery);
    }

    public void deleteAddress(int userId) throws SQLException{
        String deleteQuery = "DELETE FROM "+ ADDRESS_TABLE_NAME+" WHERE user_id = "+userId;
        connection.query(deleteQuery);
    }

    public int insertAddress(Address address,int userId) throws SQLException{
        String insertQeury = " INSERT INTO " +ADDRESS_TABLE_NAME + " (address_line1,address_line2,address_line3,city,postcode,country,user_id) VALUES ('"
                +address.getAddress1()+"','"+address.getAddress2()+"','"+address.getAddress3()+"','"+address.getCity()+"','"
                +address.getPostcode()+"','"+address.getCountry()+"',"+userId+")";
        connection.insert(insertQeury);
        return 0;
    }
}
