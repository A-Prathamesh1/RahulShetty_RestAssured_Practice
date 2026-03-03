package coding_basics.PassByValueOrReference;

class User {
    String name;
}

public class JavaPassByReference {
    public static void changeName(User j) {
        j.name = "new name"; // state of j changed, original reference remained same
        System.out.println("hash of j: " + j.hashCode());
        j = new User(); // new reference reassigned
        System.out.println("inside method: " + j.name); // new ref of j is null
    }

    public static void main(String[] args) {
        User j1 = new User();
        j1.name = "original name";
        System.out.println("hash of j1: " + j1.hashCode());
        changeName(j1); // change name is passed with the copy of reference of j1
        System.out.println(j1.name); // new name
    }
}
