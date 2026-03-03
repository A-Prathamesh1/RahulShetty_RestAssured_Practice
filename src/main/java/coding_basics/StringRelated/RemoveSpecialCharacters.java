package coding_basics.StringRelated;

public class RemoveSpecialCharacters {
    public static void main(String[] args) {
        String s = "Prathamesh@isa#great$man!";

        System.out.println(Character.isLetter('@'));

        String str = "";
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                str += ch;
            }
        }
        System.out.println("without special chars: " + str);
    }
}
