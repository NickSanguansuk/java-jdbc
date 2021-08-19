package jdbc.demo4_dao;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------");

        List<User> users = new UserDao().getUsersByLastName("Sanguansuk");

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("----------");

        List<UserRole> userRoles = new UserRoleDao().getUserRolesByLastName("Sanguansuk");

        for (UserRole userRole : userRoles) {
            System.out.println(userRole);
        }

        System.out.println("----------");

        System.out.println("End of main()");
    }
}
