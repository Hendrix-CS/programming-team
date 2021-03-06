import java.util.Comparator;

public class CPair<A extends Comparable<A>, B extends Comparable<B>> implements Comparable<CPair<A,B>> {
    A a; B b;
    public CPair(A a, B b) { this.a = a; this.b = b; }
    public int hashCode() { return 31 * (31 * 7 + a.hashCode()) + b.hashCode(); }
    public boolean equals(Object o) {
        CPair<A,B> p = (CPair<A,B>)o;
        return a.equals(p.a) && b.equals(p.b);
    }
    public String toString() { return "(" + a + "," + b + ")"; }
    public int compareTo(CPair<A,B> p) {
        return Comparator.comparing(q -> q.a).thenComparing(q -> q.b).compare(p);
    }
}
