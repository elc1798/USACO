import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class HatchingIn {

    /*
     * Pseudocode:
     *
     * Multiply by 13 to get the total number of minutes
     * Divide by 60 to get hours, remainder is minutes
     *
     */

    private static final String inputFile = "HatchingIn.txt";
    private static int numEggs;

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here
        numEggs = Integer.parseInt(br.readLine().trim());
        br.close();
    }

    private static void solve() {
        int totalMinutes = 13 * numEggs;
        int totalHours = totalMinutes / 60;
        int remainderMinutes = totalMinutes - totalHours * 60;
        System.out.printf("Cathy will be hatching eggs for %d hours and %d minutes\n" , totalHours , remainderMinutes);
    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
