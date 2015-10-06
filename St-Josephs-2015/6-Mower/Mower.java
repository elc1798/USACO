import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Mower {

    /*
     * Pseudocode:
     *
     * Mow the lawn all the way down
     * If the lawn isn't empty, turn.
     * Recursively do the above until empty.
     * Note that the turning carves out the starting corner!
     *
     */

    private static class Precisionizer { // Simulates integer with %.2f point precision
        public int INT_VALUE;
        public int FLOAT_VALUE;
        public int FULL_VALUE;

        public Precisionizer(double d) {
            FULL_VALUE = (int)(Math.round(d * 100.0));
            INT_VALUE = FULL_VALUE / 100;
            FLOAT_VALUE = FULL_VALUE % 100;
        }

        public void printVal() {
            System.out.printf("%d.%d\n" , INT_VALUE , FLOAT_VALUE);
        }
    }

    private static final String inputFile = "MowerIn.txt";
    private static double[][] data;

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here
        int numLawns = Integer.parseInt(br.readLine().trim());
        data = new double[numLawns][5];
        for (int i = 0; i < numLawns; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int k = 0; k < 5; k++) {
                data[i][k] = Double.parseDouble(line[k]);
            }
        }
        br.close();
    }

    private static void solve() {
        for (double[] lawn : data) {
            new Precisionizer(mow(lawn[2] , lawn[1] , lawn[0] , lawn[3] , lawn[4] , 0.0)).printVal();
        }
    }

    private static double mow(double x , double y , double cut , double walkSpeed , double turnSpeed , double currTime) {
        if (lawnEmpty(x , y)) {
            return currTime;
        } else {
            double newTime = currTime;
            Precisionizer X = new Precisionizer(x);
            Precisionizer Y = new Precisionizer(y);
            double deltaX = 0.0;
            double turns = 0.0;
            if (Y.FULL_VALUE > 0) {
                if (y < cut) {
                    // Do nothing
                } else {
                    newTime += (y - cut) / walkSpeed;
                }
                deltaX = 1;
            }
            if (!lawnEmpty(x - cut * deltaX, y)) {
                turns = 1.0;
            }
            if (x - cut * deltaX < 0.0) {
                return mow(y , 0.0 , cut , walkSpeed , turnSpeed , newTime + turns * turnSpeed);
            } else {
                return mow(y , x - cut * deltaX , cut , walkSpeed , turnSpeed , newTime + turns * turnSpeed);
            }
        }
    }

    public static boolean lawnEmpty(double x , double y) {
        // The lawn will only be empty if the area is 0 or less
        return new Precisionizer(x * y).FULL_VALUE <= 0;
    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
