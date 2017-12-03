import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Goh Shu Yu
 * @since   2/12/2017
 */
public class UserDao {

    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();

    public List<User> getAllUsers()throws SQLException{
        String getAllUsersSQL = "SELECT * FROM user";
        List<User> users = new ArrayList<>();
        ResultSet usersResultSet = connection.query(getAllUsersSQL);
        while (usersResultSet.next()){
            users.add(DBUtils.constructUserFromRS(usersResultSet));
        }
        return null;
    }

    public List<User> getUsersFriends(User user){
        return null;
    }

    public User getUser(int userId){
        return null;
    }

    public int updateUser(User user){
        return updateUser(user.getUserId());
    }

    public int insertUser(User user){
        return 0;
    }

    public int updateUser(int userId){
        return 0;
    }

    public int deleteUser(User user){
        return deleteUser(user.getUserId());
    }

    public int deleteUser(int userId){
        return 0;
    }
    public void updateLoginLog(int userId){};
}
