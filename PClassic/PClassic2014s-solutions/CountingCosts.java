import java.io.*;
import java.util.Arrays;


public class CountingCosts {


	private static int[] prices;
	private static int budget;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ("CountingCostsIN.txt"));
		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			budget = Integer.parseInt(data[0]);
			int numLevels = Integer.parseInt(data[1]);
			prices = new int[numLevels];
			for (int i = 0; i < numLevels; i++) {
				prices[i] = Integer.parseInt(data[i+2]);
			}
			System.out.println(ways(budget, prices));
		}
		br.close ();
	}

	public static int ways(int b, int[] p) {
		int ways[] = new int[b+1];
		ways[0] = 1;
		for (int i = 0; i < p.length; i++) {
		    for (int j = p[i]; j <= b; j++) {
		        ways[j] += ways[j - p[i]];
		    }
		}
		return ways[b];
	}

}
