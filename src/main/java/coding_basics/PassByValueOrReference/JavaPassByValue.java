package coding_basics.PassByValueOrReference;

public class JavaPassByValue {
    String name;

    public void nameChange(String name) {
        // changes made to the local variable name exists only within method
        name = "new name";
    }

    public static void main(String[] args) {
        String other_name = "some name";
        JavaPassByValue j = new JavaPassByValue();
        j.nameChange(other_name); // passing the value of other_name to nameChange
        System.out.println(other_name);
//        name = "old name";
    }
}
