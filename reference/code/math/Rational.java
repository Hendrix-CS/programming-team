class Rational implements Comparable<Rational> {
    long n, d;
    public Rational(long _n, long _d) {
        n = _n; d = _d;
        if (d < 0) { n = -n; d = -d; }
        long g = gcd(Math.abs(n),d); n /= g; d /= g;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public Rational(long n) { this(n,1); }

    public Rational plus(Rational other) {
        return new Rational(n * other.d + other.n * d, d * other.d);
    }
    public Rational minus(Rational other) {
        return new Rational(n * other.d - other.n * d, d * other.d);
    }
    public Rational negate() {
        return new Rational(-n, d);
    }
    public Rational times(Rational other) {
        return new Rational(n * other.n, d * other.d);
    }
    public Rational divide(Rational other) {
        return new Rational(n * other.d, d * other.n);
    }
    public boolean equals(Object otherObj) {
        Rational other = (Rational)otherObj;
        return (n == other.n) && (d == other.d);
    }
    public int compareTo(Rational r) {
        long diff = n * r.d - d * r.n;
        if (diff < 0) return -1;
        else if (diff > 0) return 1;
        else return 0;
    }
    public String toString() {
        return d == 1 ? ("" + n) : (n + "/" + d);
    }
}
