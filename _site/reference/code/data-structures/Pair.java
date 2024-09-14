public class Pair<A,B> {
    A a; B b;
    public Pair(A a, B b) { this.a = a; this.b = b; }
    public int hashCode() { return 31 * (31 * 7 + a.hashCode()) + b.hashCode(); }
    public boolean equals(Object o) {
        Pair<A,B> p = (Pair<A,B>)o;
        return a.equals(p.a) && b.equals(p.b);
    }
    public String toString() { return "(" + a + "," + b + ")"; }
}
