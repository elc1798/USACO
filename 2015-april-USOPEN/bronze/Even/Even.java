import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Even {
    public static int numeven = 0;

    public static ArrayList<Integer> B_vals = new ArrayList<Integer>();
    public static ArrayList<Integer> E_vals = new ArrayList<Integer>();
    public static ArrayList<Integer> S_vals = new ArrayList<Integer>();
    public static ArrayList<Integer> I_vals = new ArrayList<Integer>();
    public static ArrayList<Integer> G_vals = new ArrayList<Integer>();
    public static ArrayList<Integer> O_vals = new ArrayList<Integer>();
    public static ArrayList<Integer> M_vals = new ArrayList<Integer>();

    public static int B_evens = 0;
    public static int E_evens = 0;
    public static int S_evens = 0;
    public static int I_evens = 0;
    public static int G_evens = 0;
    public static int O_evens = 0;
    public static int M_evens = 0;

    public static void readFromFile(String fin) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String[] line;
        int numlines = Integer.parseInt(br.readLine());
        int var = 0;
        for (int i = 0; i < numlines; i++) {
            line = br.readLine().split(" ");
            var = Integer.parseInt(line[1]);
            switch (line[0].charAt(0)) {
                case 'B':
                    B_vals.add(var);
                    if (var % 2 == 0) B_evens++;
                    break;
                case 'E':
                    E_vals.add(var);
                    if (var % 2 == 0) E_evens++;
                    break;
                case 'S':
                    S_vals.add(var);
                    if (var % 2 == 0) S_evens++;
                    break;
                case 'I':
                    I_vals.add(var);
                    if (var % 2 == 0) I_evens++;
                    break;
                case 'G':
                    G_vals.add(var);
                    if (var % 2 == 0) G_evens++;
                    break;
                case 'O':
                    O_vals.add(var);
                    if (var % 2 == 0) O_evens++;
                    break;
                case 'M':
                    M_vals.add(var);
                    if (var % 2 == 0) M_evens++;
                    break;
                default:
                    break;
            }
        }
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("geteven.out"));
        fout.println(numeven);
        fout.close();
        fout = null;
    }

    public static void solve() {
        // We need the thing to be even. If we expand it and remove all the even
        // terms, we get:
        // B * M * (G + O + E + S) + I * M * (G + O + E + S)
        // = M * (G + O + E + S) * (B + I)
        // Meaning if M is even, everything is even. Regardless.
        // If both B and I are even, everything is even. Regardless.
        // If GOES is even, then everything is even. Regardless.
        boolean m_has_evens = M_evens > 0;
        if (m_has_evens) {
            numeven += M_evens * B_vals.size() * E_vals.size() * S_vals.size() * I_vals.size() * G_vals.size() * O_vals.size();
        }
        int b_i_even = B_evens * I_evens;
        int b_i_odds = (B_vals.size() - B_evens) * (I_vals.size() - I_evens);
        int b_i_total = (b_i_even + b_i_odds) * E_vals.size() * S_vals.size() * G_vals.size() * O_vals.size() * (M_vals.size() - M_evens);
        numeven += b_i_total;
        // All 4 are odd
        // TOTAL - 1 is odd - 3 are odd
        int G_odds = G_vals.size() - G_evens;
        int O_odds = O_vals.size() - O_evens;
        int E_odds = E_vals.size() - E_evens;
        int S_odds = S_vals.size() - S_evens;
        int goes = G_vals.size() * O_vals.size() * E_vals.size() * S_vals.size() -
            G_odds * O_evens * E_evens * S_evens - 
            O_odds * G_evens * E_evens * S_evens -
            E_odds * G_evens * O_evens * S_evens -
            S_odds * G_evens * O_evens * E_evens -
            G_evens * O_odds * E_odds * S_odds -
            O_evens * G_odds * E_odds * S_odds -
            E_evens * G_odds * O_odds * S_odds -
            S_evens * G_odds * O_odds * E_odds;
        numeven += goes * (M_vals.size() - M_evens) * (B_vals.size() * I_vals.size() - b_i_even - b_i_odds);
    }

    public static void main(String[] args) throws IOException{
        readFromFile("geteven.in");
        solve();
        writeout();
        System.exit(0);
    }
}
