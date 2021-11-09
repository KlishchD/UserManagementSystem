package Menu;

import DataManager.UsersManagerInterface;

import java.sql.SQLException;

public class LoggedIn extends State {
    private int option;

    public LoggedIn(UsersManagerInterface usersManager) {
        super(usersManager);
    }

    @Override
    public void enter() {
        System.out.println("(1) Change Password");
        System.out.println("(2) Log out");
        System.out.println("(3) Delete user");
        System.out.println("(4) Exit");
        option = scannerInt.nextInt();
    }

    @Override
    public void update() {
        switch (option) {
            case 1:
                current = changePassword;
                break;
            case 2:
                loggedInUser = null;
                current = authorization;
                break;
            case 3:
                current = authorization;
                try {
                    usersManager.deleteUser(loggedInUser.getUsername());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                loggedInUser = null;
                break;
            case 4:
                current = null;
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }
}
