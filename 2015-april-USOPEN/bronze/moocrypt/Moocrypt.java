import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Moocrypt {
    private static int answer = 0;
    private static int max = 0;
    private static char[][] grid;

    public static void readFromFile(String fin) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String line;
        StringTokenizer parser = new StringTokenizer(br.readLine() , " ");
        int numlines = Integer.parseInt(parser.nextToken());
        int numchars = Integer.parseInt(parser.nextToken());
        // System.out.printf("%d , %d\n" , numlines , numchars);
        grid = new char[numlines][numchars];
        for (int i = 0 ; i < numlines ; i++) {
            line = br.readLine();
            for (int k = 0 ; k < numchars ; k++) {
                grid[i][k] = line.charAt(k);
            }
        }
        parser = null;
        br = null;
        line = null;
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("moocrypt.out"));
        fout.println(max);
        fout.close();
        fout = null;
    }

    public static void solve() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0 ; i < 26 ; i++) {
            for (int k = 0 ; k < 26 ; k++) {
                if (i != k) {
                    solve("" + alphabet.charAt(i) + alphabet.charAt(k) + alphabet.charAt(k));
                    if (answer > max) {
                        max = answer;
                    }
                    answer = 0;
                }
            }
        }
    }

    public static void solve(String KEY) {
        if (KEY.equals("MOO")) {return;}
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0 ; c < grid[r].length ; c++) {
                // >
                if (c + 2 < grid[0].length &&
                        KEY.equals("" + grid[r][c] + grid[r][c+1] + grid[r][c+2])
                        ) {
                    answer++;
                }
                // <
                if (c - 2 >= 0 &&
                        KEY.equals("" + grid[r][c] + grid[r][c-1] + grid[r][c-2])
                        ) {
                    answer++;
                }
                // ^
                if (r - 2 >= 0 &&
                        KEY.equals("" + grid[r][c] + grid[r-1][c] + grid[r-2][c])
                        ) {
                    answer++;
                }
                // v
                if (r + 2 < grid.length &&
                        KEY.equals("" + grid[r][c] + grid[r+1][c] + grid[r+2][c])
                        ) {
                    answer++;
                }
                // > ^
                if (c + 2 < grid[0].length &&
                        r - 2 >= 0 &&
                        KEY.equals("" + grid[r][c] + grid[r-1][c+1] + grid[r-2][c+2])
                        ) {
                    answer ++;
                }
                // > v
                if (c + 2 < grid[0].length &&
                        r + 2 < grid.length &&
                        KEY.equals("" + grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2])
                        ) {
                    answer++;
                }
                // < ^
                if (c - 2 >= 0 &&
                        r - 2 >= 0 &&
                        KEY.equals("" + grid[r][c] + grid[r-1][c-1] + grid[r-2][c-2])
                        ) {
                    answer++;
                }
                // < v
                if (c - 2 >= 0 &&
                        r + 2 < grid.length &&
                        KEY.equals("" + grid[r][c] + grid[r+1][c-1] + grid[r+2][c-2])
                        ) {
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        readFromFile("moocrypt.in");
        solve();
        writeout();
        System.exit(0);
    }
}
