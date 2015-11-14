import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RocketBoxes {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(
				"RocketBoxesIN.txt"));

		while (br.ready()) {
			System.out.println(ways(Integer.parseInt(br.readLine())));
		}
		br.close();
	}
	public static int mchoosen(int m, int n) {
		if (n == 0) {
			return 1;
		}
		int out = 1;
		for (int i = m; i > n; i--) {
			out *= i;
		}
		int mnfact = 1;
		for (int i = 1; i <= m-n; i++) {
			mnfact *= i;
		}
		return out/mnfact;
	}
	/*
	 * This solution can be worked out more efficiently with some math
	 * Scroll to bottom for math solution
	 * Here is a less efficient solution that uses only simple combinatorics 
	 */
	public static int ways(int size) {
		int[][][] contributions = new int[size][][];
		for (int i = 1; i <= size; i++) {
			contributions[i-1] = new int[i][size];
		}
		for (int c = 0; c < size; c++) {
			Arrays.fill(contributions[size-1][c], 0);
			contributions[size-1][c][c] = 1;
		}
		for (int r = size-2; r >= 0; r--) {
			for (int c = 0; c < r+1; c++) {
				for (int i = 0; i < size; i++) {
					contributions[r][c][i] += contributions[r+1][c][i];
					if (c+1 < r+2) 
						contributions[r][c][i] += contributions[r+1][c+1][i];
				}
			}
		}
		int odds = 0;
		for (int i = 0; i < size; i++) {
			if (contributions[0][0][i]%2 == 1) odds++;
		}
		int total = 1;
		for (int i = 0; i < size; i++) {
			if (contributions[0][0][i]%2 == 0) total *= 3;
		}
		int oddcomb = 0;
		for (int n = 0; n <= odds; n+=2) {
			oddcomb += (int)(mchoosen(odds, n)*Math.pow(2.0, odds-n));
		}
		return oddcomb*total;
	}
	/*
	 * If you don't believe us heres a brute force solution to check with
	 */
	public static int check(int[][] tri) {
		for (int r = tri.length-2; r >= 0; r--) {
			for (int c = 0; c < r+1; c++) {
				tri[r][c] += tri[r+1][c];
				if (c+1 < r+2) {
					tri[r][c] += tri[r+1][c+1];
				}
			}
		}
		if (tri[0][0]%2 == 0) {
			return 1;
		}
		return 0;
	}
	public static int waysRec(int[][] tri, int c) {
		if (c == tri.length) {
			return check(tri);
		}
		tri[tri.length-1][c] = 0;
		int t = waysRec(tri, c+1);
		for (int r = 0; r < tri.length -1;r++) Arrays.fill(tri[r], 0);
		tri[tri.length-1][c] = 1;
		t += waysRec(tri, c+1);
		for (int r = 0; r < tri.length -1;r++) Arrays.fill(tri[r], 0);
		tri[tri.length-1][c] = 2;
		return t + waysRec(tri, c+1);
	}
	public static int waysBrute(int size) {
		int[][] tri = new int[size][];
		for (int i = 0; i < size; i++) {
			tri[i] = new int[i+1];
			Arrays.fill(tri[i], 0);
		}
		return waysRec(tri, 0);
	}


/*
* 	Math solution
*	
*/


	private static int findNumOdd(int k) {
		String bin = Integer.toBinaryString(k);
		int numOdd = 0;
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				numOdd++;
			}
		}
		numOdd = Math.round((float)Math.pow(2, numOdd));
		return numOdd;
	}
	
	private static int findCombinations(int k, int odd) {
		double combinations = 0;
		for (int i = odd; i > -1; i -= 2) {
			combinations += combination(odd, i);
		}
		combinations *= Math.pow(3, k - odd + 1);
		return Math.round((float)combinations);
	}
	
	private static double combination(int n, int r) {
		if ((r == n) || (r == 0)) {
			return Math.pow(2,  r);
		}
		double combo = Math.pow(2, r);
		if (r > (n/2)) {
			r = n-r;
		}
		for (int i = 0; i < r; i++) {
			combo = combo * (n - i);
				combo = combo/(i+1);
		
		}
		return combo;
	}
	
	
	private static int answer(int k) {
		int ones = findNumOdd(k-1);
		return findCombinations(k-1, ones);
	}
	


}
