/*
ID: elc1798
LANG: JAVA
TASK: friday
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class friday{

	public static final int jan = 1;
	public static final int feb = 2;
	public static final int mar = 3;
	public static final int apr = 4;
	public static final int may = 5;
	public static final int jun = 6;
	public static final int jul = 7;
	public static final int aug = 8;
	public static final int sep = 9;
	public static final int oct = 10;
	public static final int nov = 11;
	public static final int dec = 12;

	public static final int mon = 1;
	public static final int tue = 2;
	public static final int wed = 3;
	public static final int thu = 4;
	public static final int fri = 5;
	public static final int sat = 6;
	public static final int sun = 7;

	public static int febdays = 28;

	public static boolean isLeapYear(int year){
		if (year % 100 == 0){
			return year % 400 == 0;
		} else {
			return year % 4 == 0;
		}
	}

	public static int getNumDays(int month){
		if (month <= 7){
			if (month % 2 == 1) {
				return 31;
			} else if (month == 2) {
				return febdays;
			} else {
				return 30;
			}
		} else {
			if (month % 2 == 1) {
				return 30;
			} else {
				return 31;
			}
		}
	}

	public static int[] enumWeek(int year , int day){
		int[] tally = new int[7];
		for (int i = 0; i < tally.length; i++){
			tally[i] = 0;
		}
		//First day:
		int firstday = 1;
		for (int i = 1990; i < year; i++){
			if (isLeapYear(i)) {
				firstday += 366 % 7;
				febdays = 29;
			} else {
				firstday += 365 % 7;
			}
		}
		firstday = firstday % 7;
		for (int i = jan; i <= dec; i++){
			tally[(firstday + day) % 7] = tally[(firstday + day) % 7] + 1;
			firstday += getNumDays(i);
			firstday = firstday % 7;
		}
		return tally;
	}

	public static void main(String[] args){
		Scanner input = null;
		int year = 0;
		int[] output = new int[7];
		try {
			input = new Scanner(new File("friday.in"));
		} catch(Exception e){
			System.exit(0);
		}
		try {
			year = Integer.parseInt(input.next());
		} catch(Exception e){
			System.exit(0);
		}
		year += 1990;
		int[] temp;
		for (int i = 1990; i < year; i++){
			temp = enumWeek(i , 13);
			output[0] += temp[6];
			output[1] += temp[0];
			output[2] += temp[1];
			output[3] += temp[2];
			output[4] += temp[3];
			output[5] += temp[4];
			output[6] += temp[5];
		}
		PrintWriter outstream = null;
		try {
			outstream = new PrintWriter(new File("friday.out"));
		} catch(Exception e){
			System.exit(0);
		}
		String s = output[0] + " " + output[1] + " " + output[2] + " " + output[3] + " " + output[4] + " " + output[5] + " " + output[6];
		outstream.println(s);
		outstream.close();
	}

}
