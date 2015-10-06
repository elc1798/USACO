/*
ID: your_id_here
LANG: JAVA
TASK: ride
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;

public class ride{

	public static boolean check(String comet , String group){
		int cometSum = 1;
		int groupSum = 1;
		for (int i = 0; i < comet.length(); i++){
			cometSum *= ((int)comet.charAt(i) - 64);
		}
		for (int i = 0; i < group.length(); i++){
			groupSum *= ((int)group.charAt(i) - 64);
		}
//		System.out.println(cometSum + " , " + groupSum);
		return (cometSum % 47 == groupSum % 47);
	}

	public static void main(String[] args){
		Scanner input = null;
		try {
			input = new Scanner(new File("ride.in"));
		} catch(Exception e){
			System.exit(0);
		}
		ArrayList<String> in = new ArrayList<String>();
		PrintWriter output = null;
		try {
			output = new PrintWriter("ride.out" , "UTF-8");
		} catch(Exception e){
			System.exit(0);
		}
		while (input.hasNext()){
			in.add(input.next());
		}
		for (int i = 0; i < in.size() - 1; i=i+2){
			if (check(in.get(i) , in.get(i+1))){
				output.println("GO");
			} else {
				output.println("STAY");
			}
		}
		output.close();
	}

}
