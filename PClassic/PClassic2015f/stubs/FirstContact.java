import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstContact {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("FirstContactIN.txt"));

    while (br.ready()) {
      String[] input = br.readLine().split(" ");
      long numRows = Long.parseLong(input[0]);
      long divisor = Long.parseLong(input[1]);
      long modulus = Long.parseLong(input[2]);
      System.out.println(countDivisible(numRows, divisor, modulus));
    }
    br.close();
  }

  // Fill out the body of this method
  public static long countDivisible(
      long numRows, 
      long divisor,
      long modulus) {
    return 0L;
  }
}
