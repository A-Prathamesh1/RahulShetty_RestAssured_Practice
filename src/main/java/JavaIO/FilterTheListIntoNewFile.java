package JavaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class FilterTheListIntoNewFile {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("filteredlist.txt")) {
            BufferedReader br1 = new BufferedReader(new FileReader("abc.txt"));
            String l = br1.readLine();
            while (l != null) {
                BufferedReader br2 = new BufferedReader(new FileReader("abc1.txt"));
                String l2 = br2.readLine();
                boolean isEqual = false;
                while (l2 != null) {
                    if (l.equals(l2)) {
                        isEqual = true;
                        break;
                    }
                    l2 = br2.readLine();
                }
                if (!isEqual) {
                    pw.println(l);
                }
                l = br1.readLine();
            }
            br1.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
