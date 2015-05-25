import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;
public class Bales {

    private static int[] hay = new int[4000];

    private static ArrayList<Integer> stacks = new ArrayList<Integer>();

    public static void readFromFile(String fin) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String[] line;
        int numlines = Integer.parseInt(br.readLine());
        for (int i = 0; i < numlines; i++) {
            line = br.readLine().split(" ");
            hay[Integer.parseInt(line[1]) - 1] = Integer.parseInt(line[0]);
            stacks.add(Integer.parseInt(line[1] - 1));
        }
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("trapped.out"));
        fout.println( [VARIABLE NAME HERE] );
        fout.close();
        fout = null;
    }

    public static void trampel(int index , int power) {
        int h;
        h = hay[index];
        if (power != 0 && hay[index] > power) {
            return index;
        }
        for (int i = 1; i <= h; i++) {
            if (h + i < hay.length && hay[index + i] != 0 && power + i >= hay[index + i]) {
                trampel(h + i , power + i);
            }
            break;
        }
    }
    
    public static void solve() {
        for (Integer i : stack) {
            trampel(i , 0);
        }
    }

    public static void main(String[] args) throws IOException{
        readFromFile("trapped.in");
        solve();
        writeout();
        System.exit(0);
    }
}
