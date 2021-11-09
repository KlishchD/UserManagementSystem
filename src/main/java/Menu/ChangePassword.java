package Menu;

import DataManager.UsersManagerInterface;

import java.sql.SQLException;

public class ChangePassword extends State {

    public ChangePassword(UsersManagerInterface usersManager) {
        super(usersManager);
    }


    @Override
    public void enter() {
        System.out.print("Enter new password: ");
        loggedInUser.setPassword(scannerString.nextLine());

        try {
            usersManager.updateUser(loggedInUser);
            System.out.println("Password successfully updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        current = logged;
    }
}
