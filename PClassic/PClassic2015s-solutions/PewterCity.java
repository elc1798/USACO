import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PewterCity {

	public static int digitValue(char c){
		if (c == 'I'){
			return 1;
		} else if (c == 'V'){
			return 5;
		} else if (c == 'X'){
			return 10;
		} else if (c == 'L'){
			return 50;
		} else if (c == 'C'){
			return 100;
		} else {
			throw new IllegalArgumentException("Not a valid Roman digit");
		}
	}
	
	public static int value(String str){
		char[] arr = str.toCharArray();
		
		int sum = 0, digit, secondDigit;
		
		for(int index = 0; index < arr.length; index++){
			digit = digitValue(arr[index]);
			
			if(index < arr.length - 1){
				secondDigit = digitValue(arr[index + 1]);
			} else {
				secondDigit = 0;
			}
			
			if (digit >= secondDigit){
				sum += digit;
			} else{
				sum += secondDigit - digit;
				index++;
			}
		}
		
		return sum;
	}
	
	static long choose(int i, int u) {
		long num = 1, denom = 1;
		
		for (int index = i-u+1; index <= i; index++) {
			num *= index;
		}
		for (int index = 1; index <= u; index++) {
			denom *= index;
		}
		
		return num / denom;
	}
	
	public static int pathsToPewter(String iRom, String uRom){
		int i = value(iRom);
		int u = value(uRom);
		
		return (int) choose(i, u);	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("PewterCityIN.txt"));
		
		while(reader.ready()){
			String i = reader.readLine(); //First input on first line
			String u = reader.readLine(); //Second input on second line
			System.out.println(pathsToPewter(i, u));
		}
		
		reader.close();
	}
	
}
