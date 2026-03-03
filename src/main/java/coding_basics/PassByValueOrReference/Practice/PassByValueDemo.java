package coding_basics.PassByValueOrReference.Practice;

public class PassByValueDemo {
    public static void change_name(String name) {
        name = "new name"; // name exists only within changeName method
    }

    public static void main(String[] args) {
        String name = "some_name";
        change_name(name); // passing the value of name to changeName
        System.out.println("after calling change name: " + name);
    }
}
