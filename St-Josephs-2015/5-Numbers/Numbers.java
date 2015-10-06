import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.math.BigInteger;

public class Numbers {

    /*
     * Pseudocode:
     *
     * Convert the integer to binary
     * Swappity swap swap :D
     * Change back to integer
     * Output w/ correct format
     *
     */

    private static final String inputFile = "NumbersIn.txt";
    private static int[] keys;
    private static int[] data;

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here
        int num = Integer.parseInt(br.readLine().trim());
        keys = new int[num];
        data = new int[num];
        String[] tmp;
        for (int i = 0; i < num; i++) {
            tmp = br.readLine().trim().split(" ");
            keys[i] = Integer.parseInt(tmp[0]);
            data[i] = Integer.parseInt(tmp[1]);
        }
        br.close();
    }

    private static void solve() {
        for (int i = 0; i < keys.length; i++) {
            boolean negative = false;
            int val = data[i];
            if (data[i] < 0) {
                val = Integer.MAX_VALUE + val + 1;
                negative = true;
            }
            String bin = Integer.toString(val , 2);
            int bitsize = 1;
            for (int j = 0; j < keys[i]; j++) {
                bitsize *= 2;
            }
            if (bitsize == 1) {
                continue;
            }
            while (bin.length() % (bitsize * 2) != 0) {
                if (negative) {
                    bin = "1" + bin;
                } else {
                    bin = "0" + bin;
                }
            }
            for (int k = 0; k < bin.length(); k += bitsize * 2) {
                bin = bin.substring(0 , k) + bin.substring(k + bitsize , k + bitsize * 2) + bin.substring(k , k + bitsize) + bin.substring(k + bitsize * 2);
            }
            BigInteger bi = new BigInteger(bin , 2);
            int enc = bi.intValue();
            System.out.printf("%d %d %d\n" , data[i] , keys[i] , enc);
        }
    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
