import java.util.*;

public class Promotions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int E = in.nextInt();
        int P = in.nextInt();

        DAG g = new DAG(E);

        for (int i = 0; i < P; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            g.addEdge(x,y);
        }

        ArrayList<Integer> top = g.topSort();

        // System.out.println(top);

        HashMap<Integer, HashSet<Integer>> upclosed = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> downclosed = new HashMap<>();

        for (Integer v : top) {
            HashSet<Integer> upset = new HashSet<>();
            upset.add(v);
            upclosed.put(v,upset);
            for (Integer prev : g.incoming(v)) {
                upset.addAll(upclosed.get(prev));
            }
        }

        for (ListIterator<Integer> it = top.listIterator(top.size()); it.hasPrevious(); ) {
            Integer v = it.previous();
            HashSet<Integer> downset = new HashSet<>();
            downset.add(v);
            downclosed.put(v,downset);
            for (Integer next : g.neighbors(v)) {
                downset.addAll(downclosed.get(next));
            }
        }

        int Acount = 0;
        int Bcount = 0;
        int Xcount = 0;
        for (int i = 0; i < E; i++) {
            if (downclosed.get(i).size() > E - A) Acount++;
            if (downclosed.get(i).size() > E - B) Bcount++;
            if (upclosed.get(i).size() > B) Xcount++;
        }

        System.out.println(Acount);
        System.out.println(Bcount);
        System.out.println(Xcount);
    }
}

class DAG {
    private int n;
    private Object[] adj;
    private Object[] adjBack;
    private int[] inDegree;

    public DAG(int n) {
        this.n = n;
        adj = new Object[n];
        adjBack = new Object[n];
        inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<Integer>();
            adjBack[i] = new HashSet<Integer>();
        }
    }

    public void addEdge(int x, int y) {
        neighbors(x).add(y);
        incoming(y).add(x);
        inDegree[y]++;
    }

    public HashSet<Integer> neighbors(int x) {
        return (HashSet<Integer>)adj[x];
    }

    public HashSet<Integer> incoming(int x) {
        return (HashSet<Integer>)adjBack[x];
    }

    public ArrayList<Integer> topSort() {
        int[] tmpDegree = new int[n];
        Stack<Integer> degreeZero = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            tmpDegree[i] = inDegree[i];
            if (inDegree[i] == 0) {
                degreeZero.add(i);
            }
        }

        ArrayList<Integer> sorted = new ArrayList<>();

        while (!degreeZero.isEmpty()) {
            int next = degreeZero.pop();

            sorted.add(next);
            for (Integer neighbor : neighbors(next)) {
                tmpDegree[neighbor]--;

                if (tmpDegree[neighbor] == 0) {
                    degreeZero.add(neighbor);
                }
            }
        }

        return sorted;
    }
}
