package coding_basics;

import java.io.*;

public class ReadTheDataFromFile {
    public static void main(String[] args) throws IOException {
        // create variable of BufferedReader that represents file
        File f = new File("abc.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = br.readLine();
        System.out.println("Contents of the file are: ");
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}
