import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ChooseYourStarter {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("ChooseYourStarterIN.txt"));
    while (br.ready()) {
      String battleTypes = br.readLine();
      System.out.println(chooseStarter(battleTypes));
    }
    br.close();
  }

  // Fill out the body of this method
  public static String chooseStarter(String battleTypes) {
    String[] types = {"water","fire","grass","electric","rock","flying"};
    int[][] scores = {{0,-1,1},{1,0,-1},{-1,1,0},{-1,0,0},{1,-1,1},{0,0,-1}};
    String[] data = battleTypes.split(" ");
    int[] ret = new int[3];
    for (int i = 0; i < 3; i++) ret[i] = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < types.length; j++) {
        if (data[i].equals(types[j])) {
          for (int k = 0; k < 3; k++) {
            ret[k] += scores[j][k];
          }
          break;
        }
      }
    }
    if (ret[0] >= ret[1] && ret[0] >= ret[2]) {
      return "squirtle";
    } else if (ret[1] >= ret[2]) {
      return "charmander";
    }
    return "bulbasaur";
  }
}
