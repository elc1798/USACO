import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class PenguinByNorthPenguin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (
				new FileReader ("PenguinByNorthPenguinIN.txt"));
		
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double dir = Double.parseDouble(st.nextToken());
			double tolerance = Double.parseDouble(st.nextToken());
			System.out.println(getDirection(dir, tolerance));
		}
		
		br.close();
	}
	
        public static String getDirection(double dir, double tolerance) {
                //Fill in this stub
        }
}
