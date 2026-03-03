package JavaIO;

import java.io.*;
import java.util.Arrays;

public class JavaIO_Demo {
    public static void main(String[] args) throws IOException {
        // we are crating the file object to represent name abc
        File f = new File("abc.txt");
        System.out.println("does file exists: " + f.exists());
        if (!f.exists()) {
            System.out.println(f.createNewFile() ? " file created " : "failed to create file");
        }
        System.out.println("does file exists: " + f.exists());

        File f1 = new File("new folder");
        System.out.println("does folder exists: " + f1.exists());
        if (!f1.exists()) {
            System.out.println(f1.mkdir() ? "folder created " : "failed to create folder");
        }
        System.out.println("does folder exists: " + f1.exists());

//         file class constructors
        //create a file or directory in current working directory
        File f2 = new File("New Folder1");
        System.out.println(f2.mkdir() ? "folder created" : "failed to create folder");
        // create sub-directory as well as file in the directory
        //File f3 = new File("direcoryName", "filename");

        // File f4 = new File(f2, "filename");

        // create a file abc.txt in directory new folder

        File f5 = new File(f2, "abc.txt");
        System.out.println(f5.createNewFile() ? "file created " : "failed to create file");

        // create file in existing location
        File f6 = new File("C:\\Users\\prath\\Documents\\Job\\New Company\\New folder\\RahulShetty_RestAssured_Practice\\New Folder1", "demo.txt");
        System.out.println(f6.createNewFile() ? "file created" : "failed ");

        // important methods in file class for reading & writing
        System.out.println(f2.isFile() ? "its file" : "not a file");
        System.out.println(f2.isDirectory() ? "its directory" : "not a directory");

        // get list of all the directory in folder
        String[] listOfFiles = f2.list();
        System.out.println("list of files & folders from f2: l" + Arrays.toString(listOfFiles));

        // length of file
        System.out.println("length of f5: " + f5.length());

        // delete a directory or file
        System.out.println(f1.delete() ? "deleted" : "could not delete");

        // count the number of files in the given location
        // get the list of items from location
        String[] listOfItems = f2.list();
        int count = 0;
        for (String s : listOfItems) {
            File f7 = new File(f2, s);
            if (f7.isFile()) {
                count++;
            }
        }
        System.out.println("there are " + count + " files.");

        // Read & Write data to file: if the file is not available following constructors will create file
        // FileWriter: write text data to file
        // constructors: Overriding exiting data
        //1. FileWriter fw = new FileWriter(String name);
        //2. FileWriter fw = new FileWriter(File f);

//        append constructors
        //3.FileWriter fw = new FileWriter(String fname, boolean append);
        //2. FileWriter fw = new FileWriter(File f, boolean append);

        // imp methods of printWriter
        // write(int ch)
        // write(char[] ch)
        // write( String s)
        // flush() < to make sure all the data including last character is written to file
        // close()

        // write data to file using filewriter

        try (FileWriter fw = new FileWriter("abc1.txt", true)) {
            fw.write(100);
            fw.write("this \n is another line1 ");
            fw.write("\n");
            char[] ch = {'a', 'b', 'c'};
            fw.write(ch);
            fw.write('\n');
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // line separator needs to be inserted manually
        // n is not the line separator on every machine

        //FileReader: to read text data from file

        // constructors
//        FileReader fr = new FileReader(String filename);
//        FileReader fr = new FileReader(File f);

//        methods
//        int read(); > to read single char value form file> returns unicode char > if no next character -1
//        int read(char[] ch) > int size of chars being used to read
//        void close()

        FileReader fr = new FileReader("abc1.txt");
        int i = fr.read();
        System.out.println("contents of the file are: ");

        while (i != -1) {
            System.out.print((char) i);
            i = fr.read();
        }
        fr.close();

        // read using int read(char[] ch)
        File f8 = new File("abc1.txt");
        char[] ch1 = new char[(int) f8.length()]; // will work within integer range

        FileReader fr1 = new FileReader(f8);
        fr1.read(ch1); // reading data from fr1 & copying into ch1
        for (char ch2 : ch1) {
            System.out.print(ch2);
        }
        fr1.close();

        // Buffered reader is convenient in reading data line by line
        // where as FileReader reads character by character

//        BufferedWriter bw = new BufferedWriter(Writer w);
//          BufferedWriter bw = new BufferedWriter(Writer w, int bufferSize);

        // methods of bufferedWriter
//        write(int ch) > write single character to file
//        write(char[] ch)>
//        write(string l)
//        newline() > to insert new line in file
//        flush()
//        close()

        // bufferedwriter demo

        BufferedWriter bw = new BufferedWriter(new FileWriter("abc.txt"));
        bw.write(100);
        bw.newLine();
        bw.write(new char[]{'a', 'b', 'c', 'd'});
        bw.newLine();
        bw.write("Prathamesh");
        bw.newLine();
        bw.write("Software Solutions");
        bw.flush();
        bw.close(); // it closes fileWriter also

        // bufferedReader
//        BufferedReader br = new BufferedReader(Reader r, int size);
//        BufferedReader br = new BufferedReader(Reader r);

        // methods
        // int read()
        // int read(char[] ch)
        // close()
        // String readLine()

        File f9 = new File("abc.txt");
        BufferedReader br = new BufferedReader(new FileReader("abc.txt"), (int) f9.length());
        System.out.println("Contents of " + f9.getName());
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();

        // printWriter: creates file if it does not exists
        // these are the 2 readers we have 3rd writer printwriter
        // still we have to write newline() in bufferedWriter
        // to write 100 we need to pass bw.write("100")
        // if we want to write number ,double, boolean value < always string form need to be used
        // to address these problems we use printWriter.print(10), print(10.5), print(true), for new line println(100)

        // constructors of printWriter

//        PrintWriter pw = new PrintWriter("abc.txt");
//        PrintWriter pw1 = new PrintWriter(new File("abc.txt"));
//        PrintWriter pw2 = new PrintWriter(Writer w);

        // methods
        // print(any primitive value, and String)
        // println(any primitive type, and String)

        PrintWriter pw = new PrintWriter("abc.txt");
        pw.print("******************");
        pw.write(100);
        pw.println(100);
        pw.print('c');
        pw.print("some string");
        pw.flush();
        pw.close();
    }
}
