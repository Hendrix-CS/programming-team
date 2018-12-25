import java.util.*;
import java.math.*;

public class ModExpTest {
    public static void main(String[] args) {
        // BigInteger b = new BigInteger("3");
        // BigInteger inv = b.modPow(new BigInteger("-1"), new BigInteger("1000000007"));

        long m = 1000000007;
        BigInteger M = BigInteger.valueOf(m);

        boolean ok = true;
        for (long b = 2; b <= 10000; b++) {
            for (long e = 1; e <= 100000000000000000L; e *= 10) {
                ok = ok &&
                    (ModExp.modexp(b, e, m) ==
                     BigInteger.valueOf(b).modPow(BigInteger.valueOf(e), M).intValue());

                // ok = ok &&
                // (ModExp.modinv
            }
        }

        System.out.println(ok ? "OK!" : "Error!");
    }
}
