import java.io.BufferedReader;
import java.io.FileReader;

import java.io.*;

public class DiverseComposites {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("DiverseCompositesIN.txt"));
        
        while (br.ready()) {
            long n = Long.parseLong(br.readLine());            
            System.out.println(countUnder(n));
        }
        
        br.close();
    }

    public static long countUnder(long n) {
        long[] coeffs = new long[25];
        coeffs[0] = 1;
        for (int i = 1; i <= 24; i++)
            coeffs[i] = ((i+1) * (i+2) * (i+3)) / 6;
        int nb_primes = 25;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        long res = 0L;
        long up = n; //10000000000000000L;
        int nb_prod = 1 << nb_primes; // 2 ** 25
        for (int i = 1; i < nb_prod; i++) {
            long prod = 1L;
            int nb_bits = 0;
            int ok = 1;
            for (int j = 0; j < nb_primes; j++) {
                if ((i & (1 << j)) != 0) {
                    nb_bits++;
                    prod *= primes[j];
                    if (prod > up) {
                        ok = 0;
                        break;
                    }
                }
            }
            if (ok == 0) continue;
            if (nb_bits < 4) continue;
            if (nb_bits % 2 == 0)
                res += coeffs[nb_bits-4] * (up / prod);
            else
                res -= coeffs[nb_bits-4] * (up / prod);
        }
        return res;
    }
}
