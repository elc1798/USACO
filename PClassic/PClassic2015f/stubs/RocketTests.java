import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class RocketTests {
 
    public static void main(String[] args) throws IOException{
        // Before submitting, make sure the main method hasn't been changed!
        String sequence = "";
        BufferedReader br = new BufferedReader(new FileReader(
                    "RocketTestsIN.txt"));
        while (br.ready()) {
            sequence = br.readLine();
            System.out.println(longestSeq(sequence));   
        }
    }

    // Fill out the body of this method
    public static int longestSeq(String seq){
        return 0;
    }
}
