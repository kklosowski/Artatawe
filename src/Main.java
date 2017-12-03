import java.sql.SQLException;

/**
 *
 * @author shu testing
 * @since   1/12/2017
 */
public class Main {
    public static void main(String[] args){
        int userId=1;
        AddressDao addressDao = new AddressDao();
        System.out.println("hi");
        System.out.println("hi");
        try {
            Address address = addressDao.getAddress(userId);
            System.out.println("my addres of user id = 1 is "+ address.toString());
            address.setCountry("Malaysia");
            addressDao.updateAddress(address,userId);
            addressDao.deleteAddress(2);
        }catch (SQLException ex){
            System.out.println("error sad sad "+ex.getMessage());
        }

    }
}
