package JavaIO;

import java.io.*;

public class Merge2FilesLineByLine {
    public static void main(String[] args) throws IOException {
        // create printwriter reference for the 3rd file
        try (PrintWriter pw = new PrintWriter("3rdfile.txt")) {
            // create bufferedReader ref for 1st file
            BufferedReader br1 = new BufferedReader(new FileReader("abc.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("abc1.txt"));

            String l1 = br1.readLine();
            String l2 = br2.readLine();
            while (l1 != null || l2 != null) {
                if (l1 != null) {
                    pw.println(l1);
                    l1 = br1.readLine();
                }
                if (l2 != null) {
                    pw.println(l2);
                    l2 = br2.readLine();
                }
            }
            br1.close();
            br2.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
