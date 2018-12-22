class Rational implements Comparable<Rational> {
    long p, q;
    public Rational(long _p, long _q) {
        p = _p; q = _q;
        if (q < 0) { p = -p; q = -q; }
        long g = gcd(Math.abs(p),q); p /= g; q /= g;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public Rational(long p) { this(p,1); }

    public Rational plus(Rational other) {
        return new Rational(p * other.q + other.p * q, q * other.q);
    }
    public Rational minus(Rational other) {
        return plus(other.negate());
    }
    public Rational negate() {
        return new Rational(-p, q);
    }
    public Rational times(Rational other) {
        return new Rational(p * other.p, q * other.q);
    }
    public Rational divide(Rational other) {
        return new Rational(p * other.q, q * other.p);
    }
    public boolean equals(Object otherObj) {
        Rational other = (Rational)otherObj;
        return (p == other.p) && (q == other.q);
    }
    public int compareTo(Rational r) {
        long diff = p * r.q - q * r.p;
        if (diff < 0) return -1;
        else if (diff > 0) return 1;
        else return 0;
    }
    public String toString() {
        return q == 1 ? ("" + p) : (p + "/" + q);
    }
}
