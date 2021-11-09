package Menu;

import DataManager.UsersManagerInterface;

public class Authorization extends State {
    private int option;

    public Authorization(UsersManagerInterface usersManager) {
        super(usersManager);
    }

    @Override
    public void enter() {
        System.out.println("(1) Register");
        System.out.println("(2) Log in");
        System.out.println("(3) Exit");
        option = scannerInt.nextInt();
    }

    @Override
    public void update() {
        switch (option) {
            case 1:
                current = register;
                break;
            case 2:
                current = logIn;
                break;
            case 3:
                current = null;
                break;
            default:
                System.out.println("Wrong input");
        }
    }
}
