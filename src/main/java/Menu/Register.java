package Menu;

import DataManager.User;
import DataManager.UsersManagerInterface;

import java.sql.SQLException;

public class Register extends State {
    public Register(UsersManagerInterface usersManager) {
        super(usersManager);
    }

    @Override
    public void enter() {
        User User = new User();

        System.out.print("Enter a username: ");
        User.setUsername(scannerString.nextLine());
        System.out.print("Enter a password: ");
        User.setPassword(scannerString.nextLine());

        try {
            usersManager.addUser(User);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        current = authorization;
    }
}
