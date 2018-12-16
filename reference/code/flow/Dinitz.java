class FlowNetwork {
    private static final int INF = ~(1<<31);
    int[] level;
    boolean[] pruned;
    HashMap<Integer, HashMap<Integer, Edge>> adj;

    public FlowNetwork(int n) {
        level = new int[n];
        pruned = new boolean[n];
        adj = new HashMap<>();

        for (int i = 0; i < n; i++)
            adj.put(i, new HashMap<>());
    }

    public void addDirEdge(int u, int v, long cap) {
        if (adj.get(u).containsKey(v)) {
            adj.get(u).get(v).capacity = cap;
        } else {
            Edge e = new Edge(u,v,cap);
            Edge r = new Edge(v,u,0);
            e.setRev(r);
            adj.get(u).put(v, e);
            adj.get(v).put(u, r);
        }
    }

    // Add an UNdirected edge u<->v with a given capacity
    public void addEdge(int u, int v, long cap) {
        Edge e = new Edge(u,v,cap);
        Edge r = new Edge(v,u,cap);
        e.setRev(r);
        adj.get(u).put(v, e);
        adj.get(v).put(u, r);
    }

    public long maxFlow(int s, int t) {
        if (s == t) return INF;
        else {
            long totalFlow = 0;
            while (bfs(s,t)) totalFlow += sendFlow(s,t);
            return totalFlow;
        }
    }

    private long sendFlow(int s, int t) {
        for (int i = 0; i < pruned.length; i++)
            pruned[i] = false;
        return sendFlowR(s, t, INF);
    }

    private long sendFlowR(int s, int t, long available) {
        if (s == t) return available;

        long sent = 0;
        for (Edge e : adj.get(s).values()) {
            if (e.remaining() > 0 && !pruned[e.to] && level[e.to] == level[s] + 1) {
                long flow = sendFlowR(e.to, t, Math.min(available, e.remaining()));
                available -= flow; sent += flow;
                e.flow += flow; e.rev.flow -= flow;
                if (available == 0) break;
            }
        }
        if (sent == 0) pruned[s] = true;
        return sent;
    }

    private boolean bfs(int s, int t) {
        for (int i = 0; i < level.length; i++) level[i] = -1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(s); level[s] = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (Edge e : adj.get(cur).values()) {
                if (e.remaining() > 0 && level[e.to] == -1) {
                    level[e.to] = level[cur]+1;
                    q.add(e.to);
                }
            }
        }
        return level[t] >= 0;
    }
}

class Edge {
    int from, to;
    long capacity, flow;
    Edge rev;
    public Edge(int from, int to, long cap) {
        this.from = from; this.to = to; this.capacity = cap; this.flow = 0;
    }
    public void setRev(Edge rev) { this.rev = rev; rev.rev = this; }
    public long remaining() { return capacity - flow; }
}
