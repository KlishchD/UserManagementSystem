package Menu;

import DataManager.User;
import DataManager.UsersManagerInterface;

import java.util.Scanner;

public abstract class State {
    public static State current, authorization, register, logIn, logged, changePassword;

    protected static final Scanner scannerInt = new Scanner(System.in);
    protected static final Scanner scannerString = new Scanner(System.in);
    protected final UsersManagerInterface usersManager;

    public State(UsersManagerInterface usersManager) {
        this.usersManager = usersManager;
    }

    protected static User loggedInUser = null;

    public abstract void enter();

    public abstract void update();
}
