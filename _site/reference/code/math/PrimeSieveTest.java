public class PrimeSieveTest {
    public static void main(String[] args) {
        int MAX = 10*1000*1000;
        PrimeSieve P = new PrimeSieve(MAX);
        boolean ok = true;
        for (int n = 0; n <= MAX; n++) {
            ok = ok && (IsPrime.isPrime(n) == P.isPrime(n));
        }
        System.out.println(ok ? "OK!" : "Error!");
    }
}
