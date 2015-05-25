import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSMaze {

    private class Node {

        public int r;
        public int c;

        private String word = "";

        public Node(){
            r = -1;
            c = -1;
        }

        public Node(int x , int y){
            r = x;
            c = y;
        }

        public void setWord(String s){
            word = s;
        }

        public String getWord(){
            return word;
        }

    }

    private char[][] grid;
    private LinkedList<Node> queue;

    private int[] finishCoor;

    private Node finishNode;

    private int palindromes = 0;

    public BFSMaze(String fin) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fin));
            int size = Integer.parseInt(br.readLine());
            grid = new char[size][size];
            for (int i = 0; i < size; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            finishCoor = new int[]{size - 1 , size - 1};
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        queue = new LinkedList<Node>();
    }

    public int solve() {
        Node buffer = new Node(0 , 0);

        buffer.setWord("" + grid[0][0]);
        queue.addLast(buffer);

        Node current = buffer;
        ArrayList<String> paladins = new ArrayList<String>();

        while (current.r < grid.length && current.c < grid[0].length && queue.size() != 0) {
            current = queue.pollFirst();
            if (
                    current.r < 0 ||
                    current.c < 0 ||
                    current.r >= grid.length ||
                    current.c >= grid[0].length
                    ) {
                continue;
            }
            if (!paladins.contains(current.getWord()) && current.r == grid.length - 1 && current.c == grid[0].length - 1) {
                if (new StringBuilder(current.getWord()).reverse().toString().equals(current.getWord())) {
                    palindromes++;
                    paladins.add(current.getWord());
                }
                continue;
            }
            if (current.r + 1 < grid.length) {
                Node iter0 = new Node(current.r + 1 , current.c);
                iter0.setWord(current.getWord() + grid[current.r + 1][current.c]);
                queue.add(iter0);
            }
            if (current.c + 1 < grid[0].length) { 
                Node iter1 = new Node(current.r , current.c + 1);
                iter1.setWord(current.getWord() + grid[current.r][current.c + 1]);
                queue.add(iter1);
            }
        }
        return palindromes;
    }

    public static void main(String[] args) throws IOException {
        BFSMaze bfs = new BFSMaze("palpath.in");
        PrintWriter fout = new PrintWriter(new File("palpath.out"));
        fout.println(bfs.solve());
        fout.close();
        System.exit(0);
    }
}
