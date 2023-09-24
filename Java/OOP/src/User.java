// Getters and Setters
public class User {
    private String name;
    private String membership;
    private int age;

    public enum Membership {
        Bronze, Silver, Gold;
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