import DataManager.UsersManager;
import DataManager.UsersManagerInterface;
import Menu.*;

public class Main {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/College";
    private static final String USER_NAME = "root";
    private static final String USER_PASS = "1111";

    public static void main(String[] args) {
        try (UsersManagerInterface UsersManager = new UsersManager(DRIVER_NAME, DB_URL, USER_NAME, USER_PASS)) {
            State.authorization = new Authorization(UsersManager);
            State.logIn = new LogIn(UsersManager);
            State.register = new Register(UsersManager);
            State.changePassword = new ChangePassword(UsersManager);
            State.logged = new LoggedIn(UsersManager);

            State.current = State.authorization;

            while (State.current != null) {
                State.current.enter();
                State.current.update();
            }
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
    }
}
