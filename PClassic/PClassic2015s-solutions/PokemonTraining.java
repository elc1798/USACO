import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PokemonTraining {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PokemonTrainingIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int numPokemon = Integer.parseInt(data[0]);
      int startHP = Integer.parseInt(data[1]);
      int[] damageDealt = new int[numPokemon];
      int[] xpGained = new int[numPokemon];
      for (int i = 0; i < numPokemon; i++) {
        data = br.readLine().split(" ");
        damageDealt[i] = Integer.parseInt(data[0]);
        xpGained[i] = Integer.parseInt(data[1]);
      }
      System.out.println(maxExperienceGained(numPokemon, startHP, damageDealt, xpGained));
    }
    br.close();
  }

  public static int maxExperienceGained(int numPokemon, int startHP, int[] damageDealt, int[] xpGained) {
    int[][] dp = new int[numPokemon][startHP + 1];
    for (int i = 0; i < numPokemon; i++) {
      for (int j = 0; j <= startHP; j++) {
        dp[i][j] = 0;
      }
    }
    for (int i = 0; i < numPokemon; i++) {
      for (int j = 1; j <= startHP; j++) {
        if (i > 0) {
          dp[i][j] = dp[i-1][j];
        }
        if (j - damageDealt[i] > 0) {
          dp[i][j] = Math.max(dp[i][j], dp[i][j - damageDealt[i]] + xpGained[i]);
        }
      }
    }
    return dp[numPokemon - 1][startHP];
  }
}
