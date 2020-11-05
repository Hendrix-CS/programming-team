import java.util.*;

class SCC {
    static HashMap<Integer, ArrayList<Integer>> outEdges = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> inEdges = new HashMap<>();
    static ArrayList<Integer> L = new ArrayList<>();
    static HashSet<Integer> visited = new HashSet<>();
    static HashSet<Integer> assigned = new HashSet<>();
    static HashMap<Integer, ArrayList<Integer>> components = new HashMap<>();
    
    // Initialize outEdges and inEdges, then run kosarajusSccAlorithm.
    public static HashMap<Integer, ArrayList<Integer>> kosarajusSccAlgorithm() {
        for (Integer vertex : outEdges.keySet()) {
            visit(vertex);
        }
        for (int i = L.size(); i >= 0; i--) {
            assign(L.get(i), L.get(i));
        }
        return components;
    }
    
    public static void visit(int u) {
		if (!visited.contains(u)) {
			visited.add(u);

			for (Integer v : outEdges.get(u)) {
				visit(v);
			}
			L.add(u);
		}
	}
	
	public static void assign(int u, int root) {
		if (!assigned.contains(u)) {
			assigned.add(u);
			if (!components.containsKey(root)) {
				components.put(root, new ArrayList<>());
			}
			components.get(root).add(u);
			for (Integer integer : inEdges.get(u)) {
				assign(integer, root);
			}
		}
	}
}