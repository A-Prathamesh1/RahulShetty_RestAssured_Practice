package JavaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveDuplicatesFromFile {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("DuplicatesRemoved.txt")) {
            BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
            String l = br.readLine();
            while (l != null) {
                BufferedReader br1 = new BufferedReader(new FileReader("DuplicatesRemoved.txt"));
                String l2 = br1.readLine();
                boolean isDuplicate = false;
                while (l2 != null) {
                    if (l.equals(l2)) {
                        isDuplicate = true;
                        break;
                    }
                    l2 = br1.readLine();
                }
                if (!isDuplicate) {
                    pw.println(l);
                    pw.flush();
                }
                l = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
