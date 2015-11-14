import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Shirt {

	static String size(double height, double weight) {
		String[] intToString = {"S", "M", "L", "XL", "XXL", "NONE"};
		int heightResult = sizeGivenHeight(height);
		int weightResult = sizeGivenWeight(weight);
		if (heightResult > weightResult) {
			return intToString[heightResult];
		}
		else {
			return intToString[weightResult];
		}
	}
	
	static int sizeGivenHeight(double height) {
		if (height >= 0 && height <= 5) {
			return 0;
		}
		else if (height > 5 && height <= 10) {
			return 1;
		}
		else if (height > 10 && height <= 15) {
			return 2;
		}
		else if (height > 15 && height <= 20) {
			return 3;
		}
		else if (height > 20 && height <= 30) {
			return 4;
		}
		else {
			return 5;
		}
	}
	
	static int sizeGivenWeight(double weight) {
		if (weight >= 0 && weight <= 20) {
			return 0;
		}
		else if (weight > 20 && weight <= 100) {
			return 1;
		}
		else if (weight > 100 && weight <= 200) {
			return 2;
		}
		else if (weight > 200 && weight <= 400) {
			return 3;
		}
		else if (weight > 400 && weight <= 1000) {
			return 4;
		}
		else {
			return 5;
		}
	}

	//main method for reading input for text files
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("ShirtIN.txt"));
		while (in.hasNext()) {
			System.out.println(size(in.nextDouble(), in.nextDouble()));
		}
	}

}
