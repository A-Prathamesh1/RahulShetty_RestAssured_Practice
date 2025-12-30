package coding_basics.Exceptions.CustomException;

import java.util.Scanner;

public class CustomExceptionDemo {
    public static void main(String[] args) throws MyCustomException {
        MyClass mc = new MyClass();
        Scanner sc = new Scanner(System.in);
        mc.method(sc.nextInt());
    }

}
