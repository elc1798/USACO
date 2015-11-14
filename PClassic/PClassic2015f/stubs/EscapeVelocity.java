import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class EscapeVelocity {

	public static void main(String args[]) throws FileNotFoundException {
	    // Before submitting, make sure the main method hasn't been changed!
		
		Scanner fileInput = new Scanner(new File("EscapeVelocityIN.txt"));
		
		while(fileInput.hasNext()) {

			double mass = fileInput.nextDouble();
			double radius = fileInput.nextDouble();
			
			System.out.println(findEscapeVelocity(mass, radius));
			
		}
		fileInput.close();
	}

    // Fill out the body of this method
	public static int findEscapeVelocity(double m, double r) {
		return 0;
	}
}

