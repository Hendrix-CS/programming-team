import java.util.*;

class Edge implements Comparable<Edge> {
    int from, to, weight;
    public Edge(int _from, int _to, int _weight) {
        if (_from < _to) { from = _from; to = _to; }
        else             { from = _to; to = _from; }
        weight = _weight;
    }
    public int compareTo(Edge e) { return weight - e.weight; }
    public int getFrom() { return from; }
    public int getTo() { return to; }
}

public class MinSpanTree {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while (true) {
            int n = io.getInt(); int m = io.getInt();
            if (n == 0 && m == 0) break;

            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                edges.add(new Edge(io.getInt(), io.getInt(), io.getInt()));
            }

            // ----- Kruskal's algorithm -----
            Collections.sort(edges);  // sort by weight

            UnionFind uf = new UnionFind(n);
            ArrayList<Edge> mstEdges = new ArrayList<Edge>();

            for (Edge e : edges) {
                if (uf.find(e.from) != uf.find(e.to)) {
                    uf.union(e.from, e.to);
                    mstEdges.add(e);
                }
                if (mstEdges.size() == n-1) break;
            }

            // ----- Output -----
            if (mstEdges.size() != n - 1) {
                io.println("Impossible");  // No spanning tree exists
            } else {
                int total = 0;
                for (Edge e : mstEdges) total += e.weight;
                io.println(total);

                // sort edges lexicographically
                Collections.sort(mstEdges,
                   Comparator.comparing(Edge::getFrom).thenComparing(Edge::getTo));

                for (Edge e : mstEdges) io.println(e.from + " " + e.to);
            }
        }
        io.flush();
    }
}
