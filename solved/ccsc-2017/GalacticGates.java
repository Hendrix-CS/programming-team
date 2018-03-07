import java.util.*;

public class GalacticGates {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int trials = scan.nextInt();
        for(int t = 0; t < trials; t++){
            int edges = scan.nextInt();
            scan.nextLine();
            Graph g = new Graph();
            for(int i = 0; i < edges; i++){
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                g.addEdge(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            int result = g.MST();
            if (result == -1){
                System.out.println("INFINITY");
            } else {
                System.out.println(result);
            }
        }


    }


    static class Graph {

        int size;
        HashMap<String, Node> nodeMap = new HashMap<>();
        String lastSeen = "";
        public Graph() {
        }

        public void addEdge(String n1, String n2, int weight) {
            if (!nodeMap.containsKey(n1)){
                nodeMap.put(n1, new Node(n1));
            }
            if (!nodeMap.containsKey(n2)){
                nodeMap.put(n2, new Node(n2));
            }
            nodeMap.get(n1).addEdge(n2,weight);
            nodeMap.get(n2).addEdge(n1,weight);
            lastSeen = n1;
        }

        // Returns the length of  the MST
        public int MST(){
            PriorityQueue<Edge> potentialEdges = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
            HashSet<Node> seen = new HashSet<>();
            seen.add(nodeMap.get(lastSeen));
            potentialEdges.addAll(nodeMap.get(lastSeen).edges);
            int cost = 0;
            while(seen.size() < nodeMap.keySet().size() && potentialEdges.size() > 0){
                Edge e = potentialEdges.poll();
                if(!seen.contains(nodeMap.get(e.end))){
                    seen.add(nodeMap.get(e.end));
                    potentialEdges.addAll(nodeMap.get(e.end).edges);
                    cost += e.weight;
                }
            }
            if (seen.size() < nodeMap.keySet().size()){
                return -1;
            }
            return cost;



        }

    }

    static class Node {
        private String name;
        ArrayList<Edge> edges;

        public Node(String name){
            edges = new ArrayList<>();
            this.name = name;
        }

        public void addEdge(String endName, int weight){
            edges.add(new Edge(this.name, endName, weight));
        }

        public ArrayList<Edge> getEdges(){
            return edges;
        }


    }

    static class Edge {

        private int weight;
        private String start;
        private String end;

        public int getWeight() {
            return weight;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public Edge(String s, String e, int w) {
            this.start = s;
            this.end = e;
            this.weight = w;
        }


    }

}
