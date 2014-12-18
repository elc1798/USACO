import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.Arrays;

class cow {

	public boolean spots = false;;
	public int weight = 0;

	public cow(String s , int w) {
		spots = s.length() == 1;
		weight = w;
	}

}

public class learning {

	public static int spotted(cow[] hasSpots , int lowerWeightBound , int higherWeightBound) {
		//Get midpoints
		int numSpotted = 0;
		float[] midpts = new float[hasSpots.length + 1];
		midpts[0] = (float)lowerWeightBound;
		midpts[midpts.length - 1] = (float)higherWeightBound;
		for (int i = 1; i < midpts.length - 1; i++) {
			midpts[i] = ((float)(hasSpots[i - 1].weight) + (float)(hasSpots[i].weight)) / 2;
			if (hasSpots[i - 1].spots) {
				numSpotted += Math.round(midpts[i] - midpts[i - 1]);
			}
		}
		return numSpotted;
	}


	public static void main(String[] args){
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new Scanner(new File("learning.in"));
			outputStream = new PrintWriter("learning.out" , "UTF-8");
		} catch(Exception e){
			System.exit(0);
		}
		int N = Integer.parseInt(inputStream.next());
		int lW = Integer.parseInt(inputStream.next());
		int hW = Integer.parseInt(inputStream.next());
		cow[] ranch = new cow[N];
		for (int i = 0; i < N; i++){
			ranch[i] = new cow(inputStream.next() , Integer.parseInt(inputStream.next()));
		}
		int spotted = spotted(ranch , lW , hW);
		outputStream.println("" + spotted);
		outputStream.close();
	}

}
