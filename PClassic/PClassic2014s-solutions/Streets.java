import java.io.BufferedReader;
import java.io.FileReader;

import java.io.*;

public class Streets {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new FileReader ("StreetsIn.txt"));
		
		while (br.ready()) {
			int street = Integer.parseInt(br.readLine());
			
			System.out.println(direction(street));
		}
		
		br.close();
		

	}
	
	public static String direction(int street) {
		if (street == 14 || street == 25 || 
				street == 38 || street == 41 || street == 41) {
			return "N/S";
		}
		if (street < 1 || street > 69)
			return "N/A";
		if (street < 14) {
			if (street%2 == 0)
				return "S";
			return "N";
		}
		if (street < 32) {
			if (street%2 == 0)
				return "N";
			return "S";
		}
		if (street < 45) {
			if (street%2 == 0)
				return "S";
			return "N";
		}
		return "N/S";
	}

}
