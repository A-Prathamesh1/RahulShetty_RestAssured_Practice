package JavaIO;

import java.io.*;

public class MergeAllTheFilesFromFolder {
    public static void main(String[] args) throws IOException {
        // get the list of files
        try {
            File f = new File("New Folder1");
            String[] listOfFiles = f.list();
            PrintWriter pw = new PrintWriter("output.txt");

            for (String s : listOfFiles) {
                // read the file from list
                File f1 = new File("New Folder1", s);
                // write it to the op file
                BufferedReader br = new BufferedReader(new FileReader(f1));
                String l = br.readLine();
                while (l != null) {
                    pw.println(l);
                    l = br.readLine();
                }
            }
            pw.close();
            pw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
