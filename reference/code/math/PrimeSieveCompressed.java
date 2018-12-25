import java.util.*;

public class PrimeSieveCompressed {
    BitSet prime;
    public PrimeSieveCompressed(int MAX) {
        prime = new BitSet((MAX>>1) + 1);
        prime.set(1,(MAX>>1) + 1,true);
        for (int k = 1; (k+1)*(k<<1) <= MAX>>1; k++) {
            if (prime.get(k)) {
                int inc = (k<<1) | 1;
                for (int j = (k+1)*(k<<1); j <= MAX>>1; j += inc) {
                    prime.set(j,false);
                }
            }
        }
    }
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if ((n & 1) == 0) return false;
        return prime.get(n>>1);
    }
}
