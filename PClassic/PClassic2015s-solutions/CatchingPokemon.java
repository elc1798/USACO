import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CatchingPokemon {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("CatchingPokemonIN.txt"));

    while (br.ready()) {
      int numPokemon = Integer.parseInt(br.readLine());
      double[][] catchProbability = new double[numPokemon][numPokemon];
      for (int i = 0; i < numPokemon; i++) {
        String[] data = br.readLine().split(" ");
        for (int j = 0; j < numPokemon; j++) {
          catchProbability[i][j] = Double.parseDouble(data[j]);
        }
      }
      System.out.printf("%.3f\n", maxCatchProbability(numPokemon, catchProbability));
    }
    br.close();
  }

  private static double rec(int depth, double[][] catchProbability, boolean[] visited, int[] permutation) {
    int numPokemon = visited.length;
    if (depth == numPokemon) {
      double ret = 1.0f;
      for (int i = 0; i < numPokemon; i++) {
        ret *= catchProbability[i][permutation[i]];
      }
      return ret;
    }
    double mx = -1.0f;
    for (int i = 0; i < numPokemon; i++) {
      if (!visited[i]) {
        permutation[depth] = i;
        visited[i] = true;
        double prob = rec(depth+1, catchProbability, visited, permutation);
        mx = Math.max(mx, prob);
        visited[i] = false;
      }
    }
    return mx;
  }
  public static double maxCatchProbability(int numPokemon, double[][] catchProbability) {
    int[] permutation = new int[numPokemon];
    boolean[] visited = new boolean[numPokemon];
    for (int i = 0; i < numPokemon; i++) {
      permutation[i] = -1;
      visited[i] = false;
    }
    return rec(0, catchProbability, visited, permutation);
  }
}
