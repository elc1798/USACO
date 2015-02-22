import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Typo {

	private static Scanner fin = null;
	private static PrintWriter fout = null;
	private static String line = "";
	private static int[] openparens;
	private static int[] closeparens;
	private static int opened = 0;
	private static int closed = 0;

	public static void readFile() throws IOException {
		fin = new Scanner(new File("typo.in"));
		line = fin.nextLine();
		fin = null;
	}

	public static void outFile() throws IOException {
		fout = new PrintWriter(new File("typo.out"));
		String outstream = "" + getAns();
		fout.println(outstream);
		fout.close();
		fout = null;
	}

	public static int getAns() {
		int toReturn = 0;
		if (line.length() % 2 == 1) {
			return -1;
		}
		String temp = "" + line;
		for (int i = 0; i < line.length(); i++) {
			if (i < line.length() / 2) {
				if (!line.substring(i , i + 1).equals("(")) {
					toReturn++;
				}
			} else {
				if (!line.substring(i , i + 1).equals(")")) {
					toReturn++;
				}
			}
		}
		return toReturn;
	}

	public static void main(String[] args) throws IOException {
		readFile();
		openparens = new int[line.length()];
		closeparens = new int[line.length()];
		outFile();
	}

}
