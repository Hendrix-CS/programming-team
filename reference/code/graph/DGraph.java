public class DGraph {
    HashMap<Integer, ArrayList<DEdge>> adj;
    int n, m; static int INF = ~(1<<31);
    public DGraph(int n, int m) {
        adj   = new HashMap<>();
        this.n = n; this.m = m;
    }
    public void addEdge(int from, int to, int weight) {
        addDirEdge(from,to,weight); addDirEdge(to,from,weight);
    }
    public void addDirEdge(int from, int to, int weight) {
        if (!adj.containsKey(from)) adj.put(from, new ArrayList<>());
        adj.get(from).add(new DEdge(from, to, weight));
    }
    public ArrayList<DEdge> neighbors(int v) {
        ArrayList<DEdge> ret = adj.get(v);
        if (ret == null) return new ArrayList<DEdge>();
        else return ret;
    }

    public int[] dijkstra(int s) {
        int[] dad  = new int[n], dist = new int[n];
        Arrays.fill(dist, INF); dist[s] = 0;

        PriorityQueue<Integer> pq
            = new PriorityQueue<>(n, (Integer u, Integer v) -> dist[u] - dist[v]);
        pq.add(s);

        while (!pq.isEmpty()) {
            int cur = pq.remove();
            for (DEdge next : neighbors(cur)) {
                int nextDist = dist[cur] + next.weight;
                if (nextDist < dist[next.to]) {
                    dist[next.to] = nextDist;
                    pq.remove(next.to);
                    pq.add(next.to);
                    dad[next.to] = cur;
        }   }   }
        return dist;
    }
}
