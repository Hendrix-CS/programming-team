import java.util.*;

public class Dijkstra {
    static int INF = Integer.MAX_VALUE;

    // Dijkstra's algorithm.  Assumes vertices are numbered 0 .. n-1.
    // Parameters = # of vertices, start vertex, and adjacency map
    // describing the (directed, weighted) graph.
    public static int[] dijkstra(int n, int s, Map<Integer, ArrayList<Edge>> g) {
        // parent is optional. If you need access to both dist and
        // parent after dijkstra runs, just make them both global
        // static variables.
        int[] parent = new int[n], dist = new int[n];
        Arrays.fill(dist, INF); dist[s] = 0;

        PriorityQueue<Integer> pq
            = new PriorityQueue<>(n, (Integer u, Integer v) -> dist[u] - dist[v]);
        pq.add(s);

        while (!pq.isEmpty()) {
            int cur = pq.remove();
            if (!g.containsKey(cur)) continue;

            for (Edge e : g.get(cur)) {
                int next = e.to;
                int nextDist = dist[cur] + e.weight;
                if (nextDist < dist[next]) {
                    dist[next] = nextDist; parent[next] = cur;
                    pq.remove(next); pq.add(next);
                }
            }
        }
        return dist;
    }
}

class Edge {
    public int to, weight;
    public Edge(int to, int weight) { this.to = to; this.weight = weight; }
}
