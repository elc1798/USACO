import java.util.*;
import java.io.*;

public class CountingCosts{
	private int calcWays(int budget , int numBrackets , int[] bracket){
		//Init a tally system
		int[] ways = new int[budget + 1];
		ways[0] = 1;
		for (int i = 0; i < bracket.length; i++){
			for (int j = bracket[i]; j <= budget; j++){
				//Note every number can be represented as a partial sum of the numbers before it.
				ways[j] += ways[j - bracket[i]];
			}
		}
		return ways[budget];
	}

	public static void main(String[] args){
		CountingCosts c = new CountingCosts();
		int[] _1 = {4 , 3 , 1};
		int[] _2 = {5 , 3 , 8};
		int[] _3 = {5 , 1};
		System.out.println(c.calcWays(12 , 3 , _1));
		System.out.println(c.calcWays(4 , 3 , _2));
		System.out.println(c.calcWays(8 , 2 , _3));
	}
}
