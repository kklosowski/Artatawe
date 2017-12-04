import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author shu testing
 * @since   1/12/2017
 */
public class Main {
    public static void main(String[] args){
        int userId=1;
        AddressDao addressDao = new AddressDao();
        UserDao user = new UserDao();
        System.out.println("hi");
        System.out.println("hi");
        try {
            Address address = addressDao.getAddress(userId);
            System.out.println("my addres of user id = 1 is "+ address.toString());
            address.setCountry("UK");
            addressDao.updateAddress(address,userId);
//            addressDao.insertAddress(address,2);
//            new Timestamp(System.currentTimeMillis());

            List<User> userList =  user.getAllUsers();

//            User user1 = new User("testing ","shu","testing4","07523698541",address,"avatar.jpg");
//            User user1 = user.getUserByUsername("testing3");
//            System.out.println("hi" + user1.getUserId());
//            user.insertUser(user1);
//            User user1 = user.getUser(2);
//            System.out.println(user1.toString());
//            user1.setMobileNo("123456789");
//            user.updateUser(user1);
//            user.deleteUser(3);
//            user.insertFavourite(1,2);
//            user.insertFavourite(1,2);
//            List<User> userList1 = user.getUsersFavourite(1);
//            System.out.println("user favorite list " + userList1.size());
//            user.deleteFavouriteUser(1,2);

        }catch (SQLException ex){
            System.out.println("error sad sad "+ex.getMessage());
        }

    }
}
