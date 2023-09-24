public static class Main {
        public static void main(String[] args) {

            // Constructor that is not default type
            User user1 = new User("Bruno", "Gold", 20);

            printUser(user1);

        }

        public static void printUser(User user){
            System.out.println(user.getName());
            System.out.println(user.getMembership());
            System.out.println(user.getAge());
            System.out.println(user.toString()); // memory address and type data not very useful
        }
    }
}