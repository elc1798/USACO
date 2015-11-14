import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AsteroidMining {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("AsteroidMiningIN.txt"));

        while (br.ready()) {
            int numChambers = Integer.parseInt(br.readLine());
            int[] leftChamber = new int[numChambers];
            int[] rightChamber = new int[numChambers];
            for (int i = 0; i < numChambers; i++) {
                String[] chambers = br.readLine().split(" ");
                leftChamber[i] = Integer.parseInt(chambers[0]);
                rightChamber[i] = Integer.parseInt(chambers[1]);
            }
            boolean answer = isSymmetric(numChambers, leftChamber, rightChamber);
            System.out.println((answer) ? "Y" : "N");
        }
        br.close();
    }

    // Fill out the body of this method
    public static boolean isSymmetric(int numChambers, int[] leftChamber, int[] rightChamber) {
        int current = 0;
        int nextpos = 1;
        while (current < numChambers) {
            String s = "";
            int sum = 0;
            int endindex = current + nextpos;
            while (current < endindex) {
                if (leftChamber[current] == -1) { s += "N"; }
                else {
                    sum += 1;
                    s += "Y";
                }
                if (rightChamber[current] == -1) { s += "N"; }
                else {
                    sum += 1;
                    s = s + "Y";
                }
                current++;
            }
            nextpos = sum;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
            }

        }
        return true;
    }
}
