
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Carrying out insert, update and delete in the database.
 * @author  Goh Shu Yu
 * @since   2/12/2017
 */
public class UserDao {

    /**
     * Get the connection from the sqlitesingleton.
     * */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    /**
     * Table name of user in the database.
     * */
    private final String USER_TABLE = "user";
    /**
     * Table name of login log in the database.
     * */
    private final String LOGIN_LOG_TABLE = "login_log";
    /**
     * Table name of favourite user in the database.
     * */
    private final String FAVOURITE_TABLE = "favourite";

    /**
     * Retrieve all user from database.
     * @throws SQLException throws sql exception.
     * @return Return all users that exists in database.
     * */
    public List<User> getAllUsers()throws SQLException{
        String getAllUsersSQL = "SELECT * FROM "+USER_TABLE;
        List<User> users = new ArrayList<>();
        ResultSet rs = connection.query(getAllUsersSQL);
        while (rs.next()){
            users.add(DBUtils.constructUserFromRS(rs));
        }
        return users;
    }

    /**
     * Insert favourite user into database
     * @param userId The user's id.
     * @param favId The favorite user's id .
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return If insert successfully it will return any integer except 0, if unable to insert it will return 0.
     * */
    public int insertFavourite(int userId, int favId) throws SQLException{
        String insertQuery = String.format("INSERT INTO %s (user_id,fav_id) VALUES (%d,%d)",FAVOURITE_TABLE,userId,favId);
        return connection.insert(insertQuery);
    }

    /**
     * Retrieve all favourite users of a specific user from database.
     * @throws SQLException throws sql exception.
     * @return Return all favourite users in list.
     * */
    public List<User> getUsersFavourite(int userId) throws SQLException{

        String getFavouriteUsetQuery = String.format("SELECT * FROM %s WHERE user_id = %d " , FAVOURITE_TABLE, userId);
        List<User> users = new ArrayList<>();
        ResultSet rs = connection.query(getFavouriteUsetQuery);
        while (rs.next()){
            users.add(getUser(DBUtils.constructFavouriteFromRS(rs)));
        }
        return users;
    }
    /**
     * Delete favourite user from database.
     * @param userId User's id
     * @param favouriteId The user's id that required to remove from favourite list.
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return If delete successfully it will return any integer except 0, if unable to delete it will return 0.
     * */

    public int deleteFavouriteUser(int userId, int favouriteId) throws SQLException{
        String deleteQuery = String.format("DELETE FROM %s WHERE user_id = %d and fav_id = %d ",FAVOURITE_TABLE,userId,favouriteId);
        return connection.insert(deleteQuery);
    }

    /**
     * Get specific user's inform from database by user id.
     * @param userId User's id
     * @throws SQLException throws sql exception.
     * @return Return a user from database by given userid.
     * */
    public User getUser(int userId)throws SQLException{
        String searchUser = String.format("SELECT * FROM %s WHERE user_id = %d",USER_TABLE,userId);

        ResultSet rs = connection.query(searchUser);
        if (rs.next()){
            return DBUtils.constructUserFromRS(rs);
        }
        return null;
    }
    /**
     * Get specific user's inform from database by user name.
     * @param userName User's id
     * @throws SQLException throws sql exception.
     * @return Return a user from database by given userid.
     * */
    public User getUserByUsername(String userName)throws SQLException{
        String searchUser = String.format("SELECT * FROM %s WHERE username = '%s'",USER_TABLE,userName);

        ResultSet rs = connection.query(searchUser);
        if (rs.next()){
            return DBUtils.constructUserFromRS(rs);
        }
        return null;
    }

    /**
     * Update user's inform in the database.
     * @param user The new user detail that required to update the database.
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return If update successfully it will return any integer except 0, if unable to update it will return 0.
     * */
    public int updateUser(User user) throws SQLException{
        String updateQuery = String.format("UPDATE  %s SET first_name = '%s', last_name ='%s', " +
                "username = '%s', mobile_number = '%s', avatar_filename = '%s' WHERE user_id= %d",USER_TABLE,user.getFirstName(),
                user.getLastName(),user.getUserName(),user.getMobileNo(),user.getProfilePicture(), user.getUserId());

        return connection.insert(updateQuery);
    }

    /**
     * Insert new user into database.
     * @param user The new user's detail.
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return If insert successfully it will return any integer except 0, if unable to insert it will return 0.
     * */
    public int insertUser(User user)throws SQLException{

        String insertQuery = String.format("INSERT INTO %s " +
                "(first_name,last_name,username,mobile_number,avatar_filename) " +
                "VALUES ('%s','%s','%s','%s','%s')",USER_TABLE,user.getFirstName(),user.getLastName(),
                user.getUserName(),user.getMobileNo(),
                user.getProfilePicture());
        int result = connection.insert(insertQuery);
        System.out.println("result insert user " + result);
        if (result>0){
            AddressDao addressDao = new AddressDao();
            result = addressDao.insertAddress(user.getAddress(),getUserByUsername(user.getUserName()).getUserId());
        }
        return result;
    }
    /**
     * Delete user from database by user's id.
     * @param userId User's id
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return If delete successfully it will return any integer except 0, if unable to delete it will return 0.
     * */
    public int deleteUser(int userId) throws SQLException{
        String deleteQuery = String.format("DELETE FROM %s WHERE user_id = %d",USER_TABLE,userId);
        return connection.insert(deleteQuery);
    }
    /**
     * Get user's login log.
     * @param userId User's id
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return Return user's last login timestamp in long - which is not yet converted timestamp from database.
     * */
    public long getLoginLog(int userId) throws SQLException{
        String searchUserLogin = String.format("SELECT * FROM %s WHERE user_id = %d",LOGIN_LOG_TABLE,userId);
        ResultSet rs = connection.query(searchUserLogin);
        if (rs.next()){
            return DBUtils.constructLoginLogFromRS(rs);
        }
        return 0;
    }
    /**
     * Update user's login log.
     * @param userId User's id
     * @throws SQLException Throws sql exception if there is any connection error.
     * @return If update successfully it will return any integer except 0, if unable to update it will return 0.
     * */
    public int updateLoginLog(int userId) throws SQLException{
        String insetQuery = String.format("INSERT INTO %s (user_id,timestamp) VALUES (%d,%d)",LOGIN_LOG_TABLE, userId,System.currentTimeMillis());
        String updateQuery = String.format("UPDATE %s SET timestamp = %d" ,LOGIN_LOG_TABLE,System.currentTimeMillis());
        if (getLoginLog(userId)>0){
            return connection.insert(updateQuery);
        }else {
            return connection.insert(insetQuery);
        }
    }
}
