import java.util.*;

class ArticulationPoints {
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static boolean[] visited = new boolean[0]; // Initialize to the num of vertices.
    static int[] depth = new int[0]; // Same here.
    static int[] parent = new int[0]; // Same here. Initialize all parents to Integer out of your bounds of vertices. We'll call that -1 in this example.
    static int[] low = new int[0]; // And here.
    
    // initialize your graph and the arrays accordingly then call ArticulationPoints(i, 0) on all vertices i that haven't been visited. 
    public static void articulationPoints(int i, int d) {
        visited[i] = true;
        depth[i] = d;
        low[i] = d;
        int childCount = 0;
        boolean isArticulation = false;
        
        for (Integer ni : graph.get(i)) {
            if (!visited[ni]) {
                parent[ni] = i;
                articulationPoints(ni, d + 1);
                childCount++;
                if (low[ni] >= depth[i]) {
                    isArticulation = true;
                }
                low[i] = Math.min(low[i], low[ni]);
            }
            else if (ni != parent[i]) {
                low[i] = Math.min(low[i], depth[ni]);
            }
        }
        if ((parent[i] != -1 && isArticulation) || (parent[i] == -1 && childCount > 1)) {
            System.out.println(i + " is an Articulation Point.");
        }
    }
}