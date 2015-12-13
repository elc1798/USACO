import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class SAMPLE {

    private static String INPUT = "";
    private static String OUTPUT = "";
    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String line = "";

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        line = fin.nextLine();
        fin = null;
    }

    public static void outFile() throws IOException {
        fout = new PrintWriter(new File(OUTPUT));
        String outstream = getAns();
        fout.println(outstream);
        fout.close();
        fout = null;
    }

    public static String getAns() {
        return "";
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }
}
