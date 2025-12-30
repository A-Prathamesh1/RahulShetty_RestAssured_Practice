package coding_basics.Exceptions;

import java.io.FileReader;
import java.util.Scanner;

public class ExceptionDemo {


    public static void main(String[] args) {
        try (FileReader f = new FileReader("C:\\Users\\praausek\\Documents\\Courses\\PS_IND_EMBARK_0-90_Days.txt")) {
            int i = f.read();
            System.out.println(i);
        } catch (Exception e) {
//        s = i;
//        System.out.println(sAr[10] + " this ");
            System.out.println("this will execute" + e.getMessage());
        }
    }
}
