import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class FindCow {

	private static Scanner fin = null;
	private static PrintWriter fout = null;
	private static String line = "";
	private static int[] hindLegs;
	private static int[] frontLegs;
	private static int numhind = 0;
	private static int numfront = 0;

	public static void readFile() throws IOException {
		fin = new Scanner(new File("cowfind.in"));
		line = fin.nextLine();
		fin = null;
	}

	public static void outFile() throws IOException {
		fout = new PrintWriter(new File("cowfind.out"));
		String outstream = "" + getAns();
		fout.println(outstream);
		fout.close();
		fout = null;
	}

	public static int getAns() {
		int toReturn = 0;
		for (int i = 0; i < line.length() - 1; i++) {
			if (line.substring(i , i + 2).equals("((")) {
				hindLegs[numhind] = i;
				numhind++;
			}
			if (line.substring(i , i + 2).equals("))")) {
				frontLegs[numfront] = i;
				toReturn += numhind;
				numfront++;
			}
		}
		return toReturn;
	}

	public static void main(String[] args) throws IOException {
		readFile();
		hindLegs = new int[line.length()];
		frontLegs = new int[line.length()];
		outFile();
	}

}
