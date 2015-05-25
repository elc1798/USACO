import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;

public class PalinPath {
    
    private class Node {
        int r;
        int c;

        String word;

        public Node(int x , int y) {
            r = x;
            c = y;
        }

        public void setWord(String s) {
            word = s;
        }

        public String getWord() {
            return word;
        }
    }

    private int palins = 0;
    private char[][] grid;
    private int lim;

    private ArrayList<String> blacklist = new ArrayList<String>();

    public void readFromFile(String fin) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String line;
        int numlines = Integer.parseInt(br.readLine());
        lim = numlines - 1;
        grid = new char[numlines][numlines];
        for (int i = 0; i < numlines; i++) {
            grid[i] = br.readLine().toCharArray();
        }
    }

    public void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("palpath.out"));
        fout.println(palins);
        fout.close();
        fout = null;
    }

    private Node start , iter1 , iter2;

    public void solve() {
        if (grid[0][0] != grid[lim][lim]) {
            return;
        } else {
            start = new Node(0 , 0);
            start.setWord(Character.toString(grid[0][0]));
            dfs(start);
        }
    }

    public void dfs(Node n) {
        if (n.r == lim && n.c == lim) {
            if (!blacklist.contains(n.getWord()) && new StringBuilder(n.getWord()).reverse().toString().equals(n.getWord())) {
                palins++;
                blacklist.add(n.getWord());
            }
        } else {
            if (n.r + 1 <= lim) {
                iter1 = new Node(n.r + 1 , n.c);
                iter1.setWord(n.getWord() + grid[n.r + 1][n.c]);
            }
            if (n.c + 1 <= lim) {
                iter2 = new Node(n.r , n.c + 1);
                iter2.setWord(n.getWord() + grid[n.r][n.c + 1]);
            }
            dfs(iter1);
            dfs(iter2);
        }
    }

    public static void main(String[] args) throws IOException{
        PalinPath pp = new PalinPath();
        pp.readFromFile("palpath.in");
        pp.solve();
        pp.writeout();
        System.exit(0);
    }
}
