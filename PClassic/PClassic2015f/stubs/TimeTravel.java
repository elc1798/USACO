import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class TimeTravel {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(
                "TimeTravelIN.txt"));
        while (br.ready()) {
            String[] data = br.readLine().split(" ");
            int N = (int)Math.sqrt(data.length);
            int[][] times = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    times[i][j] = Integer.parseInt(data[N*i+j]);
                }
            }
 
            System.out.println(canTimeTravel(times.clone()));
        }
        br.close();
    }
    
    public static boolean canTimeTravel(int[][] times) {
        return false;
    }
}