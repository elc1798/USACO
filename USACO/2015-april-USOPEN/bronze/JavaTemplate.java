import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class [INSERT NAME HERE] {
    public static void readFromFile(String fin) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String line;
        StringTokenizer parser = new StringTokenizer(br.readLine() , " ");
        // Parse Input here
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("PROBLEM.out"));
        fout.println( [VARIABLE NAME HERE] );
        fout.close();
        fout = null;
    }

    public static void solve() {

    }

    public static void main(String[] args) throws IOException{
        readFromFile("PROBLEM.in");
        solve();
        writeout();
        System.exit(0);
    }
}
