import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class ConfusingCollinearConstellation {
    public static void main(String[] args) throws IOException {
    	// Before submitting, make sure the main method hasn't been changed!
        BufferedReader br = new BufferedReader(new FileReader(
                "ConstellationIN.txt"));
        while (br.ready()) {
            String[] data = br.readLine().split(" ");
            int[] pts;
            pts = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                pts[i] = Integer.parseInt(data[i]);
            }
            System.out.println(hasCollinear(pts));
        }
        br.close();
    }

    // Fill out the body of this method
    private static boolean hasCollinear(int[] pts) {
        return false;
    }
 
}
