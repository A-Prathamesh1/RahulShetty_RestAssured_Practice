package CustomExceptionDemo;

public class GuessOPException {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            System.out.println(a);
        } catch (ArithmeticException e) {
            // more specific exception types should be caught first instead of generic one
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
