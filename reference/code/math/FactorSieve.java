import java.util.*;

public class FactorSieve {
    int[] smallest;
    public FactorSieve(int MAX) {
        smallest = new int[MAX+1];
        smallest[1] = 1;
        int p = 2;
        for (; p*p <= MAX; p++) {     // Sieve up to $\sqrt{\mathrm{MAX}}$
            if (smallest[p] == 0) {
                smallest[p] = p;
                for (int m = p*p; m <= MAX; m += p)
                    if (smallest[m] == 0) smallest[m] = p;
            }
        }
        for (; p <= MAX; p++)         // Fill in remaining primes
            if (smallest[p] == 0)
                smallest[p] = p;
    }

    public ArrayList<Long> factor(long n) {
        ArrayList<Long> factors = new ArrayList<>();
        while ((n & 1L) == 0) { factors.add(2L); n >>= 1L; }
        long d = 3;
        // Pull out factors until n is small enough to look up
        while (d*d <= n && n >= smallest.length) {
            if (n % d == 0) {
                factors.add(d);
                n /= d;
            } else {
                d += 2;
            }
        }
        // Now just look up remaining factors in the table
        if (n < smallest.length) {
            while (smallest[(int)n] != n) {
                factors.add((long)(smallest[(int)n]));
                n /= smallest[(int)n];
            }
        }
        if (n != 1) factors.add(n);
        return factors;
    }
}
