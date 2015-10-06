import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class [STUB] {

    /*
     * Pseudocode:
     *
     *
     *
     */

    private static final String inputFile = "STUBIn.txt";

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here

        br.close();
    }

    private static void solve() {

    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
