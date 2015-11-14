import java.util.*;
import java.io.*;
class Podracing
{
    public static void main(String[] args)throws IOException
    {
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

    static void EqualSums(int N, int[] A)
    {
        // TODO: You must implement this method
    }

}
