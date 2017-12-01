import java.util.List;

/**
 *
 * @author  Kamil Klosowski
 * @since   1/12/2017
 */
public class UserDao {
    public List<User> getAllUsers(){
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
}
