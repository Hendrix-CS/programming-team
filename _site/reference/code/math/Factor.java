import java.util.*;

public class Factor {
    public static ArrayList<Integer> factor(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        while ((n & 1) == 0) { factors.add(2); n >>= 1; }  // get factors of 2
        int d = 3;                 // get odd factors
        while (d*d <= n) {         // $O(\sqrt n)$
            if (n % d == 0) {
                factors.add(d);    // found a factor
                n /= d;
            } else {               // try next odd divisor
                d += 2;
            }
        }
        if (n != 1) factors.add(n);  // don't forget final prime
        return factors;
    }
}
