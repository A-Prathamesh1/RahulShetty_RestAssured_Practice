package DSA.OperatorsAndBinNumSys;

public class OperatorsDemo {
    public static void main(String[] args) {
        // pre increment operator
        // ++a <- pre , a++ <- post
        int a = 10;
        int b = 0;
        b = ++a; // first increment the a and then assign
        System.out.println("After Pre increment a: " + a); // 11
        System.out.println("After Pre increment b: " + b); // 11

        // post increment a++
        int x = 10;
        int y = 0;

        y = x;
        x++;
        System.out.println("post increment x: " + x); // 11
        System.out.println("post increment y: " + y); // 10
    }
}
