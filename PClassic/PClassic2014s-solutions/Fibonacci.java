import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class Fibonacci {
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new FileReader ("FibbonacciIn.txt"));
		
		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			String num = data[0];
			System.out.println(isGood(num));
		}
		
		
		br.close ();
	}

	public static String isGood(String n) {
		HashSet<String> fibonaccis = new HashSet<String>();
		int f1 = 1;
		int f2 = 1;
		fibonaccis.add("1");
		while (f1 < Integer.MAX_VALUE - f2) {
			int f3 = f1+f2;
			f1 = f2;
			f2 = f3;
			
			fibonaccis.add(Long.toString(f3));
		}
		
		
		
		boolean[] ends = new boolean[n.length()];
		
		int i = 0;
		while (i < n.length()) {
			if (i == 0 || ends[i-1]) {
				for (int j = i+1; j <= n.length(); j++) {
					String num = n.substring(i, j);
					if (fibonaccis.contains(num)) {
						ends[j-1] = true;
					}
				}
			}
			i++;
		}
		if (ends[ends.length-1])
			return "GOOD";
		return "BAD";
	}
}
