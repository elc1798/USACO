import java.util.*;
import java.io.*;

public class Podracing {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("PodracingIN.txt"));
        int T =  in.nextInt();
        while(T-- >0){
            int N = in.nextInt();
            int A[] = new int[N];
            for(int i = 0 ; i < N ; i++)
                A[i] = in.nextInt();
            EqualSums(N, A);
        }
    }

    public static void EqualSums(int N, int[] A) {
        int sum = 0;
        for (int i : A) { sum += i; }
        if (sum % 2 == 1) {
            System.out.println("false");
            return;
        }
        boolean part[][] = new boolean[sum / 2 + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            part[0][i] = true; // If sum = 0, then true
        }
        for (int i = 1; i <= sum / 2; i++) {
            part[i][0] = false; // If N = 0, the false
        }
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= N; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= A[j - 1]) {
                    part[i][j] = part[i][j] || part[i - A[j-1]][j-1];
                }
            }
        }
        System.out.println(part[sum/2][N]);
        return;
    }

}
