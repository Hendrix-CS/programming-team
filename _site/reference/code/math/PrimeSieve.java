import java.util.*;

public class PrimeSieve {
    BitSet prime;
    public PrimeSieve(int MAX) {
        prime = new BitSet(MAX+1);
        prime.set(2,MAX+1,true);              // initialize all to true
        for (int p = 2; p*p <= MAX; p++)      // iterate up to $\sqrt{\mathrm{MAX}}$
            if (prime.get(p))                 // found a prime p
                for (int m = p*p; m <= MAX; m += p)  // cross out multiples of p
                    prime.set(m,false);
    }
    public boolean isPrime(int n) {  // Once sieve is built, test primality in $O(1)$
        return prime.get(n);
    }
}
