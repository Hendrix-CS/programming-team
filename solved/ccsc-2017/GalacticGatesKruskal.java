// CCSC-midsouth 2017 programming contest
// Problem 4, "Galactic Conundrum"
// Solution with Kruskal's algorithm (union-find)

import java.util.*;
import java.io.*;

public class GalacticGatesKruskal {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("galactic.in"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        int N = in.nextInt();

        for (int T = 0; T < N; T++) {
            int D = in.nextInt();
            in.nextLine();

            Graph<String, Integer> graph = new Graph<>();

            for (int d = 0; d < D; d++) {
                String[] data = in.nextLine().split(" ");
                String v1 = data[0], v2 = data[1];
                int cost = Integer.parseInt(data[2]);

                graph.addEdge(v1, v2, cost);
            }

            ArrayList<Integer> minCosts = graph.minSpanningTree();
            if (minCosts == null)
                System.out.println("INFINITY");
            else {
                int total = 0;
                for (Integer cost : minCosts)
                    total += cost;
                System.out.println(total);
            }
        }
    }
}

// A weighted edge, with a Comparable instance so edges can be sorted
// by weight.
class Edge<V, E extends Comparable<E>> implements Comparable<Edge<V, E>> {
    V v1, v2;
    E weight;

    public Edge(V v1, V v2, E weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight  = weight;
    }

    public int compareTo(Edge<V, E> other) {
        return weight.compareTo(other.weight);
    }
}

// Undirected, weighted graphs with vertices of type V and
// edge weights of type E.
class Graph<V, E extends Comparable<E>> {
    HashSet<V> vertices;
    HashMap<V, HashMap<V,E>> adj;

    public Graph() {
        vertices = new HashSet<>();
        adj      = new HashMap<>();
    }

    public void addEdge(V v1, V v2, E weight) {
        vertices.add(v1);
        vertices.add(v2);

        if (!adj.containsKey(v1))
            adj.put(v1, new HashMap<>());
        if (!adj.containsKey(v2))
            adj.put(v2, new HashMap<>());

        adj.get(v1).put(v2, weight);
        adj.get(v2).put(v1, weight);
    }

    // Create a list of all the edges.
    public ArrayList<Edge<V,E>> edges() {
        ArrayList<Edge<V,E>> es = new ArrayList<>();

        for (V v : vertices) {
            for (Map.Entry<V,E> end : adj.get(v).entrySet()) {
                es.add(new Edge<V,E>(v, end.getKey(), end.getValue()));
            }
        }
        return es;
    }

    // Kruskal's algorithm for finding the minimum spanning tree.
    // Return the costs of all edges in an MST if there is one, or
    // null if the graph is not connected.  Note I find Kruskal's
    // algorithm easier than Prim's algorithm, IF you understand how
    // to implement a union-find structure. Overall it is simpler and
    // there is less to get wrong.
    public ArrayList<E> minSpanningTree() {

        // Get the list of edges and sort them by increasing weight.
        ArrayList<Edge<V,E>> es = edges();
        Collections.sort(es);

        // Create a union-find structure with each vertex in its own
        // component.
        UnionFind<V> uf = new UnionFind<>();
        for (V v : vertices) {
            uf.addSingleton(v);
        }

        // Now loop through the edges from smallest to biggest weight,
        // and include each edge if it does not create a cycle,
        // i.e. connect two vertices which are already in the same
        // connected component.
        ArrayList<E> minCosts = new ArrayList<>();
        for (Edge<V,E> edge : es) {
            if (!uf.find(edge.v1).equals(uf.find(edge.v2))) {
                uf.union(edge.v1, edge.v2);
                minCosts.add(edge.weight);
            }
        }

        // We have a spanning tree iff the number of edges is one less
        // than the number of vertices.
        if (minCosts.size() == vertices.size() - 1)
            return minCosts;
        else
            return null;
    }
}

// A basic union-find structure, with union by rank.
class UnionFind<V> {
    HashMap<V,V> parent;
    HashMap<V,Integer> size;

    public UnionFind() {
        parent = new HashMap<>();
        size   = new HashMap<>();
    }

    // Add an item as a new singleton set.
    public void addSingleton(V item) {
        parent.put(item, item);
        size.put(item, 1);
    }

    // Find the representative of the set containing item.  O(log n).
    public V find(V item) {
        // Don't bother with path compression since it would just be
        // icing on the cake.
        while (!parent.get(item).equals(item)) {
            item = parent.get(item);
        }
        return item;
    }

    // Union the sets containing v1 and v2.  O(log n).
    public void union(V v1, V v2) {
        // Union by rank: we always make the smaller set a child
        // of the larger, which is enough to guarantee O(log n) find.

        v1 = find(v1);
        v2 = find(v2);

        if (size.get(v1) < size.get(v2)) {
            parent.put(v1, v2);
            size.put(v2, size.get(v2) + size.get(v1));
        } else {
            parent.put(v2, v1);
            size.put(v1, size.get(v1) + size.get(v2));
        }
    }
}
