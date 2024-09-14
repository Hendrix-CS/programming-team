public class GCD {
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static EGCD egcd(long a, long b) {
        if (b == 0) return new EGCD(a, 1, 0);
        EGCD e = egcd(b, a % b);
        return new EGCD(e.g, e.y, e.x - a / b * e.y);
    }
}

class EGCD {  // For storing result of egcd function
    long g, x, y;
    public EGCD(long _g, long _x, long _y) {
        g = _g; x = _x; y = _y;
    }
}

