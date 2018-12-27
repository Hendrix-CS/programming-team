import java.util.*;

public class FactorSieve {
    int[] smallest;
    public FactorSieve(int MAX) {
        smallest = new int[MAX+1];
        for (int p = 2; p*p < MAX; p++)
            if (smallest[p] == 0)
                for (int m = p*p; m <= MAX; m += p)
                    if (smallest[m] == 0) smallest[m] = p;
    }
    public ArrayList<Integer> factor(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        while ((n & 1) == 0) { factors.add(2); n >>= 1; }
        int d = 3;
        while (d*d <= n && n >= smallest.length) {
            if (n % d == 0) {
                factors.add(d); n/= d;
            } else {
                d += 2;
            }
        }
        if (n < smallest.length) {
            while (smallest[n] > 0) {
                factors.add(smallest[n]);
                n /= smallest[n];
            }
        }
        if (n != 1) factors.add(n);
        return factors;
    }
}
