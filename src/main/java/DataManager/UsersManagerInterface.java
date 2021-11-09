package DataManager;

import java.sql.SQLException;

public interface UsersManagerInterface extends AutoCloseable {
    public void addUser(User User) throws SQLException;

    public boolean checkUser(String username, String password) throws SQLException;

    public void deleteUser(String username) throws SQLException;

    public void updateUser(User User) throws SQLException;
}
