/*
ID: elc17981
PROG: gift1
LANG: JAVA
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Gift1 {

	static Scanner fin = null;
	static PrintWriter fout = null;

	static int N = -1;
	static ArrayList<String> names = new ArrayList<String>();
	static int[] money = null;
	static int temp = -1;
	static int startVal = 0;
	static int dividing = 0;

	public static void readFile() throws IOException {
		fin = new Scanner(new File("gift1.in"));
		N = Integer.parseInt(fin.nextLine().trim());
		money = new int[N];
		String next_line = "";
		for (int i = 0; i < N; i++) {
			names.add(fin.nextLine().trim().toUpperCase());
			money[i] = 0;
		}
		for (String thing : names) {
			System.out.print(thing + " ");
		}
		System.out.println();
		while (fin.hasNext()) {
			next_line = fin.next().trim().toUpperCase();
			System.out.println("Next Line: " + next_line);
			temp = Collections.binarySearch(names , next_line);
			if (temp == -1) { temp = names.size() - 1; }
			System.out.println("Found " + next_line + " @ " + temp);
			startVal = Integer.parseInt(fin.next().trim());
			dividing = Integer.parseInt(fin.next().trim());
			System.out.println(startVal + " " + dividing);
			money[temp] += startVal / (dividing + 1);
			for (int i = 0; i < dividing; i++) {
				next_line = fin.next().trim().toUpperCase();
				temp = Collections.binarySearch(names , next_line);
				if (temp == -1) { temp = names.size() - 1; }
				System.out.println("Loop 2: Found " + next_line + " @ " + temp);
				money[temp] += startVal / (dividing + 1);
			}

			System.out.println(Arrays.toString(money));
		}
	}

	public static void writeFile() throws IOException {
		fout = new PrintWriter(new File("gift1.out"));
		String outstream = "";
		for (int i = 0; i < N; i++) {
			fout.println(names.get(i).toLowerCase() + " " + money[i]);
		}
		fout.close();
	}

	public static void main(String[] args) throws IOException {
		readFile();
		writeFile();
	}

}
