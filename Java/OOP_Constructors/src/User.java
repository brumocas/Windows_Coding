public class User {
    private String name = "Unknown";
    private String membership = "Unavailable";
    private int age;

    public enum Membership {
        Bronze, Silver, Gold;
    }

    // Constructor
    public User(String name,String membership, int age){
            setName(name);
            setMembership(membership);
            setAge(age);
    }

    // Constructor default type
    public User(){
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    // Method overloading example
    void setMembership(String membership) {
        this.membership = membership;
    }
    // Method overloading example
    void setMembership(Membership membership) {
        this.membership = membership.name();
    }

    String getMembership() {
        return membership;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }
}