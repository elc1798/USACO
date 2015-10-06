import java.util.*;
import java.io.*;

public class PhiladelphiaExperiment{
	private String alphabeta = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private int findLoc(char c){
		int index = -1;
		for (int i = 0; i < alphabeta.length(); i++){
			if (alphabeta.charAt(i) == c){
				index = i;
			}
		}
		return index;
	}

	private String decrypt(int y, int g, int p, String cipher){
		//y = g ** x (mod p)
		int m = g % p;
		//int x = (int)(Math.log10(y) / Math.log10(m));
		//Hope to fucking hell that the thing is an int pre-cast

		int x = 0;
		for (int i = 0; i < p; i++){
			if (y == Math.pow(g , i) % p){
				x = i;
				break;
			}
		}
		String decipher = "";
		for (int j = 0; j < cipher.length(); j++){
			char toShift = alphabeta.charAt((x + findLoc(cipher.charAt(j))) % 26);
			decipher += toShift;
		}
		return decipher;
	}

	public static void main(String[] args){
		PhiladelphiaExperiment comp = new PhiladelphiaExperiment();
		System.out.println(comp.decrypt(80,5,105,"GZRDNZGGDN"));
		System.out.println(comp.decrypt(15,6,51,"ZQAUXQHJ"));
		System.out.println(comp.decrypt(23,7,29,"JWPAYDKZKOD"));
	}
}
