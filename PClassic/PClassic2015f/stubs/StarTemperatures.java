import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class StarTemperatures {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("StarTemperaturesIN.txt"));
 
    while (br.ready()) {
      int numStars = Integer.parseInt(br.readLine());
      int[] temperatures = new int[numStars];
      String[] strTemperatures = br.readLine().split(" ");
      for (int i = 0; i < numStars; i++) {
        temperatures[i] = Integer.parseInt(strTemperatures[i]);
      }
      int[] answers = medianTemperatures(temperatures);
      for (int i = 0; i < numStars; i++) {
        System.out.println(answers[i]);
      }
    }
    br.close();
  }
 
  // Fill out the body of this method
  public static int[] medianTemperatures(int[] temperatures) {
    return new int[temperatures.length];
  }
}