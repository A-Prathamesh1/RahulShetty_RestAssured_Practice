package coding_basics.PassByValueOrReference.Practice;

class User {
    String name;
}

public class PassByReference {

    public static void changeName(User u) {
        u.name = "new name";
        System.out.println("hash code after:" + u.hashCode());
        u = new User(); // reassignment only affects after fields modified after reassignment
        System.out.println("hash code after reassignment:" + u.hashCode());
    }

    public static void main(String[] args) {
        User u = new User();
        u.name = "some name";
        System.out.println("hash code before:" + u.hashCode());
        changeName(u);
        System.out.println("after calling change name: " + u.name);

    }

}
