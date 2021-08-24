package mariadb.demo2_dao;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------");
        {
            List<User> users = new UserDao().getUsersByLastName("Sanguansuk");

            for (User user : users) {
                System.out.println(user);
            }

            System.out.println("---");

            users = new UserDao().getUsersByLastName("Smith");

            for (User user : users) {
                System.out.println(user);
            }
        }
        System.out.println("----------");
        {

        }
        System.out.println("----------");
        {

        }

    }
}
