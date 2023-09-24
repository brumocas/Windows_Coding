public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        User u = new User();
        // Setters
        u.setName("Bruno");
        //u.setMembership("Gold"); // Method overloading example
        u.setMembership(User.Membership.Silver);
        u.setAge(20);

        //Getters
        System.out.println(u.getName());
        System.out.println(u.getMembership());
        System.err.println(u.getAge());

    }
}