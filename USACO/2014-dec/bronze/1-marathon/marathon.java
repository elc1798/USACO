import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class marathon {

	public static int getDist(int x1 , int x2 , int y1 , int y2){
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static int distances(int[] xVals , int[] yVals){
		int sum = 0;
		for (int i = 0; i < xVals.length - 1; i++){
			sum += getDist(xVals[i] , xVals[i + 1] , yVals[i] , yVals[i + 1]);
		}
		return sum;
	}

	public static int getFromArray(int[] xVals , int[] yVals){
		int sumDist = distances(xVals , yVals);
		int save = sumDist;
		int currMin = 2147483647;
		for (int i = 1; i < xVals.length - 1; i++){
			sumDist = sumDist - getDist(xVals[i - 1] , xVals[i] , yVals[i - 1] , yVals[i]) - getDist(xVals[i] , xVals[i + 1] , yVals[i] , yVals[i + 1]) + getDist(xVals[i - 1] , xVals[i + 1] , yVals[i - 1] , yVals[i + 1]);
			if (sumDist < currMin) {
				currMin = sumDist;
			}
			sumDist = save;
		}
		return currMin;
	}

	public static void main(String[] args){
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new Scanner(new File("marathon.in"));
		} catch(Exception e){
			System.exit(0);
		}
		try {
			outputStream = new PrintWriter("marathon.out" , "UTF-8");
		} catch(Exception e){
			System.exit(0);
		}
		int N = Integer.parseInt(inputStream.next());
		int[] xVal = new int[N];
		int[] yVal = new int[N];
		int tick = 0;
		for (int i = 0; inputStream.hasNext(); i++) {
			if (i % 2 == 0){
				xVal[tick] = Integer.parseInt(inputStream.next());
			} else {
				yVal[tick] = Integer.parseInt(inputStream.next());
				tick++;
			}
		}
		String answer = "" + getFromArray(xVal , yVal);
		outputStream.println(answer);
		outputStream.close();
	}
}
