import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Stub {

    private static String INPUT = "angry.in";
    private static String OUTPUT = "angry.out";
    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String[] line = new String[1];
    private static int[] bales;
    private static int numPart;

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        line = fin.nextLine().trim().split(" ");
        numPart = Integer.parseInt(line[1]);
        bales = new int[Integer.parseInt(line[0])];
        for (int i = 0; i < bales.length; i++) {
            bales[i] = Integer.parseInt(fin.nextLine().trim());
        }
        Arrays.sort(bales);
        fin = null;
    }

    public static void outFile() throws IOException {
        fout = new PrintWriter(new File(OUTPUT));
        String outstream = getAns();
        fout.println(outstream);
        fout.close();
        fout = null;
    }

    public static String getAns() {
        // System.out.println(Arrays.toString(bales));
        // System.out.println(numPart);
        // Build differences to locate partitions
        int[] diffs = new int[bales.length - 1];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = bales[i + 1] - bales[i];
        }
        // System.out.println(Arrays.toString(diffs));
        // Get intervals to iterate along
        int[] partitions = new int[numPart + 1];
        for (int i = 0; i < numPart - 1; i++) {
            int max = 0;
            int maxIndex = 0;
            for (int index = 0; index < diffs.length; index++) {
                if (diffs[index] > max) {
                    max = diffs[index];
                    maxIndex = index;
                }
            }
            diffs[maxIndex] = -1;
            partitions[i + 1] = maxIndex + 1;
        }
        partitions[0] = 0;
        partitions[numPart] = bales.length - 1;
        Arrays.sort(partitions);
        System.out.println(Arrays.toString(partitions));
        // Get the powers
        int maxPower = 0;
        for (int i = 0; i < partitions.length - 1; i++) {
            int lowerBound = partitions[i];
            int upperBound = partitions[i + 1] - 1;
            if (i == partitions.length - 2) upperBound++;
            // System.out.println(bales[lowerBound] + ", " + bales[upperBound]);
            int reqPower = (1 + bales[upperBound] - bales[lowerBound]) / 2;
            // System.out.println("REQ: " + reqPower);
            if (reqPower > maxPower) {
                maxPower = reqPower;
            }
        }
        return "" + maxPower;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }
}
