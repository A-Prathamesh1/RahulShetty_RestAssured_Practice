package coding_basics.StringRelated;

public class RemoveSpacesFromGivenString {
    public static void main(String[] args) {
        String s = "This is good";
        s = s.replaceAll("\\s", "");
        System.out.println("spaces removed: " + s);
    }
}
