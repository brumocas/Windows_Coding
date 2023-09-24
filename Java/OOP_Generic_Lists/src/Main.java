import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Constructor that is not default type
        User user1 = new User("Bruno", "Gold", 20);
        ArrayList<User> users = new ArrayList<User>();

        users.add(user1);
        users.add(new User("Berto", User.Membership.Bronze.name(), 56));

        printUser(users.get(0));
        printUser(users.get(1));

        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    public static void printUser(User user) {
        System.out.println(user.getName());
        System.out.println(user.getMembership());
        System.out.println(user.getAge());
        //System.out.println(user.toString()); // memory address and type data not very useful
        System.out.println();
    }
}

