import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Maggie {

    /*
     * Pseudocode:
     *
     * Read inputs
     * Check if the total prices are between the bounds, apply the appropriate
     * discount
     *
     */

    private static final String inputFile = "MaggieIn.txt";
    private static double[] discounts = new double[]{0.95 , 0.90 , 0.80 , 0.65};
    private static double[] spree;

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here
        int sprees = Integer.parseInt(br.readLine().trim());
        spree = new double[sprees];
        for (int i = 0; i < sprees; i++) {
            spree[i] = Double.parseDouble(br.readLine().trim());
        }
        br.close();
    }

    private static void solve() {
        for (int i = 0; i < spree.length; i++) {
            double tmp = spree[i];
            if (tmp <= 25.00) {
                // Do nothing
            } else if (tmp <= 50.00) {
                tmp = tmp * discounts[0];
            } else if (tmp <= 75.00) {
                tmp = tmp * discounts[1];
            } else if (tmp <= 100.00) {
                tmp = tmp * discounts[2];
            } else {
                tmp = tmp * discounts[3];
            }
            // Round
            tmp = tmp * 100;
            tmp = Math.round(tmp);
            tmp = tmp / 100;
            System.out.printf("%.2f\n" , tmp);
        }
    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
