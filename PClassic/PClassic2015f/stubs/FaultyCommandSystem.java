import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FaultyCommandSystem {

	public static void main(String args[]) throws FileNotFoundException {
		// Before submitting, make sure the main method hasn't been changed!
		Scanner fileInput = new Scanner(new File("FaultyCommandSystemIN.txt"));
		
		while(fileInput.hasNext()) {
			String input = fileInput.nextLine();

			String[] tempArray = input.trim().split("\\s*,\\s*");
			ArrayList<Integer> inputArray = new ArrayList<Integer>();
			for(int i = 0; i < tempArray.length; i++) {
				inputArray.add(Integer.parseInt(tempArray[i]));
			}
			
			int displacement = FaultyCommandSystem.getDisplacement(inputArray);
			
			System.out.println(displacement);
		}
		fileInput.close();
	}

	// Fill out the body of this method
	public static int getDisplacement(ArrayList<Integer> inputArray) {
		return 0;
	}
}
