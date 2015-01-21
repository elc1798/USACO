/*
ID: elc17981
PROG: gift1
LANG: JAVA
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Gift1 {

	static Scanner fin = null;
	static PrintWriter fout = null;

	static int N = -1;
	static String[] names = null;
	static int[] money = null;
	static int temp = -1;
	static int startVal = 0;
	static int dividing = 0;

	public static void readFile() throws new IOException {
		fin = new Scanner(new File("gift1.in"));
		N = Integer.parseInt(fin.nextLine());
		money = new int[N];
		money.fill(0);
		for (int i = 0; i < N; i++) {
			names[i] = fin.nextLine();
		}
		while (fin.hasNext()) {
			temp = Collections.binarySearch(names , fin.nextLine());
			startVal = Integer.parseInt(fin.next());
			dividing = Integer.parseInt(fin.next());
			money[temp] += startVal / (dividing + 1);
			for (int i = 0; i < dividing; i++) {
				temp = Collections.binarySearch(names , fin.nextLine());
				money[temp] += startVal / (dividing + 1);
			}
		}
	}

	public static void writeFile() throws new IOException {
		fout = new PrintWriter(new File("gift1.out"));
		String outstream = "";
		for (int i = 0; i < N; i++) {
			outstream += names[i] + " " + money + "\n";
		}
		fout.write();
		fout.close();
	}

	public static void main(String[] args) {
		readFile();
		writeFile();
	}

}
