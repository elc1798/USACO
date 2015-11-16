import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class FindCow {

    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String line = "";

    public static void readFile() throws IOException {
        fin = new Scanner(new File("cowfind.in"));
        line = fin.nextLine();
        fin = null;
    }

    public static void outFile() throws IOException {
        fout = new PrintWriter(new File("cowfind.out"));
        String outstream = "" + getAns();
        fout.println(outstream);
        fout.close();
        fout = null;
    }

    public static int getAns() {
        int toReturn = 0;
        boolean notSearched = true;
        int numClosed = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            if (line.substring(i, i+2).equals("((")) {
                if (notSearched) {
                    for (int k = i + 1; k < line.length() - 1; k++) {
                        if (line.substring(k, k+2).equals("))")) numClosed++;
                    }
                    notSearched = false;
                }
                toReturn += numClosed;
            } else if (line.substring(i, i+2).equals("))") && !notSearched) {
                numClosed--;
            }
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }

}
