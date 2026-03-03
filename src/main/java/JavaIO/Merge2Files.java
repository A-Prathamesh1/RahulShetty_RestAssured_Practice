package JavaIO;

import java.io.*;

public class Merge2Files {

    public static void writeToFile(String fromFile, PrintWriter toFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fromFile));
        String line = br.readLine();
        while (line != null) {
            toFile.println(line);
            line = br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        // create reference of 3rd file
        File f3 = new File("3rdfile.txt");
        System.out.println(f3.createNewFile() ? "File Created" : "failed to create file");
        // create reference of 3rd files to write in the file
        try (PrintWriter pw = new PrintWriter(f3)) {
            // read the first file
            writeToFile("abc.txt", pw);
            writeToFile("abc1.txt", pw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
