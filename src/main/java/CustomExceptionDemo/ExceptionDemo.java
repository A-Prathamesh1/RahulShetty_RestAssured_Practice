package CustomExceptionDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args) throws IOException {
        Throwable t;
        Error e;
        OutOfMemoryError o = new OutOfMemoryError("Insufficient mem");
        // throw new Error(o);
        // throw new Error(new StackOverflowError("stack overflow"));

        // Exception ex;
        // following line may throw IO exception, so better declare it, compile time we get to know
        FileReader f = new FileReader("abc.txt");
        int s = f.read();

//         RuntimeException r; can not do anything, unless code changes performed after getting exception
        try {
            int[] ar = {1, 2, 3};
            System.out.println(ar[5]);
            int i = 10;
            int res = i / 0;

        } catch (ArrayIndexOutOfBoundsException | ArithmeticException aiob) {
            System.out.println(aiob.getMessage());
            aiob.printStackTrace();
        } finally {
            System.out.println("this shall execute");
        }
    }
}
