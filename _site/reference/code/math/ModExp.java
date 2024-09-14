public class ModExp {
    public static long modexp(long b, long e, long m) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * b) % m; // include current power of b?
            b = (b * b) % m;                       // square to get next power of b
            e >>= 1;                               // shift out rightmost bit of e
        }
        return res;
    }
}
