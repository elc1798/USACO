import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;

public class Hop {

    public static char[][] board;
    public static int numhop = 1;
    public static int[][] numR;
    public static int[][] numB;
    public static char start;
    public static char end;
    public static int numLines;
    public static char currentColor;

    public static void readFromFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        numLines = Integer.parseInt(br.readLine().substring(0 , 1));
        String currline = br.readLine();
        board = new char[numLines][currline.length()];
        for (int i = 0; i < numLines; i++) {
            for (int k = 0; k < currline.length(); k++) {
                board[i][k] = currline.charAt(k);
            }
            currline = br.readLine();
        }
    }

    public static int[] getDupes(int i , int move) {
        if (i < 0 || move < 0) {
            return new int[]{0 , 0};
        }
        int _r = 0;
        int _b = 0;
        for (int _i = 0; _i < i; _i++) {
            for (int k = 0; k < move; k++) {
                if (board[_i][k] == 'R') { _r += numR[_i][k]; }
                else { _b += numB[_i][k]; }
            }
        }
//        System.out.printf("%d , %d\n" , _r , _b);
        return new int[]{_r , _b};
    }

    public static void solve() {
        start = board[0][0];
        end = board[board.length - 1][board.length - 1];
        currentColor = start;
        if (start == 'R') {
            numR[0][0] = 1;
        } else {
            numB[0][0] = 1;
        }
        for (int i = 1; i < board.length; i++) {
  //          System.out.printf("========= %d ==========\n" , i);
            for (int k = 0; k < board[i].length; k++) {
                int[] dupes = getDupes(i , k);
                if (board[i][k] == 'R') {
                    numR[i][k] += dupes[1];
                } else {
                    numB[i][k] += dupes[0];
                }
            }
        }
        switch (end) {
            case 'R':
                numhop = numR[numR.length - 1][numR[0].length - 1];
                break;
            case 'B':
                numhop = numB[numB.length - 1][numB[0].length - 1];
                break;
        }
    }

    public static void process() {
        solve();
        /*
        for (int i = 0; i < numR.length; i++) {
            System.out.println(Arrays.toString(numR[i]));
        }
        for (int i = 0; i < numB.length; i++) {
            System.out.println(Arrays.toString(numB[i]));
        }
        */
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("hopscotch.out"));
        fout.println(numhop);
        fout.close();
        fout = null;
    }

    public static void main(String[] args) throws IOException {
        readFromFile(new File("hopscotch.in"));
        numR = new int[board.length][board[0].length];
        numB = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(numR[i] , 0);
            Arrays.fill(numB[i] , 0);
        }
        process();
        writeout();
    }

}
