import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Stub {

    private static String INPUT = "div7.in";
    private static String OUTPUT = "div7.out";
    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String line = "";
    private static int[] nums;

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        line = fin.nextLine().trim();
        nums = new int[Integer.parseInt(line)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(fin.nextLine().trim()) % 7;
        }
        fin = null;
    }

    public static void outFile() throws IOException {
        fout = new PrintWriter(new File(OUTPUT));
        String outstream = getAns();
        fout.println(outstream);
        fout.close();
        fout = null;
    }

    public static boolean canDiv7(int i) {
        return i == (i / 7) * 7;
    }

    public static String getAns() {
        int[] sums = new int[nums.length];
        int maxlength = 0;
        for (int i = 0; i < sums.length; i++) {
            int sum = 0;
            sums[i] = nums[i];
            for (int j = i + 1; j < sums.length; j++) {
                sums[j] = (nums[j] + sums[j - 1]) % 7;
                if (sums[j] == 0 && j - i + 1 > maxlength) {
                    maxlength = j - i + 1;
                }
            }
            // System.out.println(Arrays.toString(sums[i]));
        }
        return "" + maxlength;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }
}
