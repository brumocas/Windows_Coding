public class Main {
    public static void main(String[] args) {

        // Constructor that is not default type
        User user1 = new User("Bruno", "Gold", 20);
        User user2 = new User("Joana", User.Membership.Bronze.name(), 23);

        // Constructor that is default type
        User user3 = new User();

        user3.setName("Joaquim");
        user3.setMembership("Silver");
        user3.setAge(43);

        printUser(user1);
        printUser(user2);
        printUser(user3);

    }

    public static void printUser(User user){
        System.out.println(user.getName());
        System.out.println(user.getMembership());
        System.out.println(user.getAge());
        System.out.println();
    }
}