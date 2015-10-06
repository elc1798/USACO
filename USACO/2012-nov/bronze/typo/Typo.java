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
		fin.close();
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
        System.out.println(line);
        for (int k = 0; k < line.length(); k++) {
            String trial = line;
            if (line.charAt(k) == '(') {
                trial = line.substring(0 , k) + ')' + line.substring(k + 1);
            } else {
                trial = line.substring(0 , k) + '(' + line.substring(k + 1);
            }
            int removals = 0;
            System.out.println(trial);
		    for (int i = 0; i < trial.length(); i++) {
                if (trial.charAt(i) == '(') {
                    removals++;
                } else {
                    removals--;
                }
            }
            if (removals == 0) {
                toReturn++;
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
