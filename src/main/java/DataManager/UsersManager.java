package DataManager;

import java.sql.*;

public class UsersManager implements UsersManagerInterface {
    private final String INSERT_QUERY = "INSERT INTO Users (username, password) VALUES(?, ?)";
    private final String GET_QUERY = "SELECT * FROM Users WHERE username = ?";
    private final String DELETE_QUERY = "DELETE FROM Users WHERE username = ?";
    private final String UPDATE_QUERY = "UPDATE Users SET password = ? WHERE username = ?";

    private final Connection connection;

    public UsersManager(String DriverName, String databaseURL, String userName, String userPassword) throws ClassNotFoundException, SQLException {
        Class.forName(DriverName);

        connection = DriverManager.getConnection(databaseURL, userName, userPassword);
    }

    @Override
    public void addUser(User User) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, User.getUsername());
            statement.setString(2, User.getPassword());

            statement.executeUpdate();
        }
    }

    @Override
    public boolean checkUser(String username, String password) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(GET_QUERY)) {

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            return resultSet.getString("password").equals(password);
        }
    }

    @Override
    public void deleteUser(String username) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, username);

            statement.executeUpdate();
        }
    }

    @Override
    public void updateUser(User User) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, User.getPassword());
            statement.setString(2, User.getUsername());

            statement.executeUpdate();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
