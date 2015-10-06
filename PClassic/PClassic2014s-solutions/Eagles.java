import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Eagles {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ("EaglesIN.txt"));
		while (br.ready ()) {
			String[] driveStrings = br.readLine ().split(",");
			int[] drive = new int[driveStrings.length];
			for (int i = 0; i < driveStrings.length; i++) {
				drive[i] = Integer.parseInt(driveStrings[i]);
			}
			System.out.println (driveAnalyzer (drive));
		}
		br.close ();
	}

	public static String driveAnalyzer (int[] drive) {
		int totalYds = 0; // touchdown at 100 yards
		int downYds = 0;  // first down at 10 yards, reset down to 1
		int down = 1;

		for (int yds : drive) {
			totalYds += yds;
			downYds += yds;

			if (totalYds < 0) {
				return "SAFETY";
			} else if (totalYds >= 100) {
				return "TOUCHDOWN";
			} else if (downYds >= 10) {
				// first down; reset the chains
				down = 1;
				downYds = 0;
			} else if (down == 4) {
				// 4th down, and we did not convert
				return "TURNOVER";
			} else {
				// next down; already have updated the yardages
				down++;
			}
		}

		return "IN PROGRESS";
	}
}