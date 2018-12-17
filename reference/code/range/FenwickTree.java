class FenwickTree {
    private long[] a;
    public FenwickTree(int n) { a = new long[n+1]; }

    // A[i] += delta. O(lg n).
    public void add(int i, long delta) {
        for (; i < a.length; i += LSB(i)) a[i] += delta;
    }

    // query [i..j]. O(lg n).
    public long range(int i, int j) { return prefix(j) - prefix(i-1); }

    private long prefix(int i) {   // query [1..i]. O(lg n).
        long s = 0; for (; i > 0; i -= LSB(i)) s += a[i]; return s;
    }
    private int LSB(int i) { return i & (-i); }
}
