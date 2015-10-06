import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LevenshteinDistance {
	// DON'T EDIT THE MAIN METHOD!
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ("LevenshteinDistanceIN.txt"));
		while (br.ready ()) {
			String[] words = br.readLine ().split(",");
			System.out.printf ("%d\n", levenshteinDistance(words[0], words[1]));
		}
		br.close ();
	}

	public static int levenshteinDistance (String s1, String s2) {
		return levenshteinDistance (s1, s1.length(), s2, s2.length());
	}

	private static int levenshteinDistance (String s1, int i, String s2, int j) {
		// if we're done with the first string, we must do j insertions to get
		// the second string
		if (0 == i) {
			return j;
		}

		// if we're done with the second string, we must do i deletions to get
		// to it from the first string
		if (0 == j) {
			return i;
		}

		// if the two characters are not identical, incur a substitution cost
		int cost = s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1;

		int deletion = 1 + levenshteinDistance (s1, i - 1, s2, j);
		int insertion = 1 + levenshteinDistance (s1, i, s2, j - 1);
		int substitution = cost + levenshteinDistance (s1, i - 1, s2, j - 1);

		return Math.min(deletion, Math.min(insertion, substitution));
	}
}