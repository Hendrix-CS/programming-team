import java.util.*;

class DFS {
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    // You can either use a HashSet or an array of booleans to keep track
    // of your visited vertices. Array of boolean is the best choice 
    // whenever the number of vertices within the graph is small, and
    // if all of the vertices have a high chance of being visited. 
    static HashSet<Integer> visited = new HashSet<>();
    
    // Initialize graph then run dfs on your starting vertex.
    public static void dfs(Integer start) {
        visit(start);
        // Here you can check to see which vertices start is connected to.
    }
    
    public static void visit(Integer v) {
        if (!visited.contains(v)) {
            
            visited.add(v);
            // At this point you would also keep track of the time that each vertex was found
            // if the problem requires it.  
            // Do any tracking or operations you want (e.g. Parent map, print output, etc...)
            for (Integer u: graph.get(v)) {
                visit(u);
            }
        }
    }
}