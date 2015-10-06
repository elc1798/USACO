import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhiladelphiaExperiment {
	// DON'T EDIT THE MAIN METHOD!
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ("PhiladelphiaExperimentIN.txt"));
		while (br.ready ()) {
			String[] params = br.readLine ().split (",");
			int y = Integer.parseInt (params[0]);
			int g = Integer.parseInt (params[1]);
			int p = Integer.parseInt (params[2]);
			System.out.println (philadelphiaExperiment(y, g, p, params[3]));
		}
		br.close ();
	}

	/**
	  * We want to solve for x in the equation y = g^x mod p, then use x as the
	  * number of characters by which to rotate the ciphertext to obtain the
	  * true, unencrypted password.
	  */
	public static String philadelphiaExperiment (int y, int g, int p,
		String ciphertext) {
		int x = discreteLog (y, g, p);
		System.out.println("x is " + x);
		return caesar (ciphertext, x);
	}

	/**
	  * We want to solve for x in the equation y = g^x mod p.
	  */
	private static int discreteLog (int y, int g, int p) {
		int x;
		for (x = 0; x < p; x++) {
			int result = (int) Math.pow (g, x) % p;
			if (y == result) {
				return x;
			}
		}
		throw new IllegalArgumentException ("should not hit this");
	}

	private static String caesar (String ciphertext, int x) {
		StringBuilder builder = new StringBuilder ();
		for (int i = 0; i < ciphertext.length (); i++) {
			char c = ciphertext.charAt (i);
			// if x is 26 or above, we want it to wrap back around
			char d = (char)((int)c + (x % 26));
			// if we've gone above ASCII Z, wrap back around
			d -= d > 'Z' ? 26 : 0;
			builder.append (d);
		}
		return builder.toString ();
	}
}