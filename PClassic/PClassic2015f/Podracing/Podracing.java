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

    public static boolean isSubSum(int N, int[] A, int sum) {
        if (sum < 0) return false;
        else if (sum == 0) return true;
        else if (N == 0 && sum != 0) return false;
        else {
            return isSubSum(N - 1, A, sum) || isSubSum(N - 1, A, sum - A[N-1]);
        }
    }

    public static void EqualSums(int N, int[] A) {
        int sum = 0;
        for (int i : A) { sum += i; }
        if (sum % 2 == 1) System.out.println(false);
        else {
            System.out.println(isSubSum(N, A, sum));
        }
    }

}
