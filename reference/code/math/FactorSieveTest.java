import java.util.*;

public class FactorSieveTest {
    public static void main(String[] args) {
        boolean ok = true;
        FactorSieve f = new FactorSieve(100000);
        for (int n = 1; n <= 200000; n++) {
            ArrayList<Integer> ps = f.factor(n);
            int prod = 1;
            for (Integer p : ps) {
                ok = ok && IsPrime.isPrime(p);
                if (!ok) {
                    System.out.println("While testing " + n + ", ps = " + ps);
                    System.out.println(p + " is not prime!");
                    System.exit(0);
                }
                prod *= p;
            }
            ok = ok && (prod == n);
            if (!ok) {
                System.out.println("While testing " + n + ", ps = " + ps + ", product = " + prod);
                System.exit(0);
            }
        }
        System.out.println("OK!");
    }
}
