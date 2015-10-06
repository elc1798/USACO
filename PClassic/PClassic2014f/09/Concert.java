import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Concert {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader
            ("ConcertIN.txt"));

        while (br.ready()) {
            String base = br.readLine();
            String height = br.readLine();
            String[] pillars = br.readLine().split(" ");
            double[] pillarDoubles = new double[pillars.length];
            for (int i = 0; i < pillars.length; i++) {
                pillarDoubles[i] = Double.parseDouble(pillars[i]);
            }

            System.out.println(computeSeatingCapacity(
                Double.parseDouble(base),
                Double.parseDouble(height),
                pillarDoubles
            ));
        }
    }

    // Fill out the body of this method
    public static int computeSeatingCapacity(double base, double height, double[] pillars) {
        double b1, b2, m1, m2, x01, x02, x1, x2, y;
	double totalA = 0.0;
	int amount = (pillars.length)/3;
	for (int i = 0; i < amount; i += 3){
		//System.out.println(amount);
		x1 = pillars[i];
		//System.out.println("x1 	:" + x1);
		x2 = pillars[i + 1];
		//System.out.println("x2	:" + x2);
		y = pillars[i + 2];
		//System.out.println("y	:" + y);
		m1 = ((height - y)/(base * 0.5 - x1));
		//System.out.println("m1	:" + m1);
		m2 = ((height - y)/(base * 0.5 - x2));
		//System.out.println("m2	:" + m2);
		b1 = height - m1 * base * 0.5;
		//System.out.println("b1 =  :" + b1);
		b2 = height - m2 * base * .5;
		//System.out.println("b2  :" + b2);
		x01 = -1.0 * b1/m1;
		//System.out.println("x01  :" + x01);
		x02 = -1.0 * b2/m2;
		//System.out.println("x02  :" + x02);
		totalA += 0.5 * (Math.abs(x2 - x1) + Math.abs(x02 - x01)) * y;
	}
	totalA = 0.5 * base * height - totalA;
	totalA *= 21;
	return (int)totalA;
    }
}
