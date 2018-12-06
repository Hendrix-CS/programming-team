public class UnionFind {
    private byte[] r; private int[] p;
    public UnionFind(int n) {
        r = new byte[n]; p = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = 0; p[i] = i;
        }
    }
    public int find(int v) {
        while (v != p[v]) {
            p[v] = p[p[v]]; v = p[v];
        }
        return v;
    }
    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
    public void union(int u, int v) {
        int ru = find(u), rv = find(v);
        if (ru != rv) {
            if      (r[ru] > r[rv]) p[rv] = ru;
            else if (r[rv] > r[ru]) p[ru] = rv;
            else {
                p[ru] = rv;
                r[rv]++;
            }
        }
    }
}
