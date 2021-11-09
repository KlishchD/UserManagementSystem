package Menu;

import DataManager.User;
import DataManager.UsersManagerInterface;

import java.sql.SQLException;

public class LogIn extends State {

    private String username;
    private String password;

    public LogIn(UsersManagerInterface usersManager) {
        super(usersManager);
    }

    @Override
    public void enter() {
        System.out.print("Enter a user name: ");
        username = scannerString.nextLine();

        System.out.print("Enter a user password: ");
        password = scannerString.nextLine();
    }

    @Override
    public void update() {
        try {
            if (usersManager.checkUser(username, password)) {
                System.out.println("Successfully logged in");
                loggedInUser = new User(username, password);
                current = logged;
            } else {
                System.out.println("Wrong user name or a password");
                current = authorization;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
