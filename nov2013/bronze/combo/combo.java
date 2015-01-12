import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class combo {

	public int possibilities(int N , int[] fjCombo , int[] masterCombo) {
		//Check combo lengths
		if (fjCombo.length != 3 || masterCombo.length != 3) {
			System.exit(0);
		}
		for (int i = 0; i < 3; i++) {
			if (Math.abs(N - fjCombo[i]) <= N) {
				
			}
		}
	}

}
