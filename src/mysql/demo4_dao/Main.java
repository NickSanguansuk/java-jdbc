package mysql.demo4_dao;

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
        System.out.println("UPDATE set user id 1 firstName to Conea");

        new UserDao().updateUserFirstNameById("Conea", 1);

        System.out.println("----------");
        System.out.println("INSERT a user");

        new UserDao().insertUser();

        System.out.println("----------");
        System.out.println("DELETE user by id");
        // This user has to be new (meaning that this user don't have id in other table such as userroles)

        new UserDao().deleteUserById(6);

        System.out.println("----------");

        System.out.println("End of main()");
    }
}
