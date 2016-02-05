import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Stub {

    private static String INPUT = "gates.in";
    private static String OUTPUT = "gates.out";
    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String line = "";

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        line = fin.nextLine();
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
        System.out.println(line);
        int v = 1000;
        int h = 1000;
        int regions = 0;
        int[][] map = new int[2001][2001];
        for (int i = 0; i < 2001; i++) {
            Arrays.fill(map[i], 0);
        }
        map[v][h] = map[v][h] + 1;
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case 'N':
                    v++;
                    break;
                case 'S':
                    v--;
                    break;
                case 'W':
                    h--;
                    break;
                case 'E':
                    h++;
                    break;
                default:
                    break;
            }
            map[v][h] = map[v][h] + 1;
            if (map[v][h] >= 2) regions++;
            // System.out.println(line.charAt(i) + " " + v + " " + h);
        }
        return "" + regions;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }
}
