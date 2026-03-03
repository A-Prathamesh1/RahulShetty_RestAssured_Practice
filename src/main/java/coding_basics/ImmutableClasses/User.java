package coding_basics.ImmutableClasses;

public final class User {
    private final String name = "Prathamesh";

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        System.out.println("name of user: " + new User().getName());
    }
}
