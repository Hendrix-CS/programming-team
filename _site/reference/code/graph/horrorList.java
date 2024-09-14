import java.util.*;

public class horrorList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int movie_num = in.nextInt();
        int horror_num = in.nextInt();
        int linked_num = in.nextInt();
        int[] scores = new int[movie_num];
        Queue<Integer> hi = new ArrayDeque<Integer>();
        for(int i = 0; i < movie_num; i++) {
            scores[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < horror_num; i++) {
            int a = in.nextInt();
            scores[a] = 0;
            hi.add(a);
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int j = 0;
        while (j < linked_num) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(! graph.containsKey(a)) graph.put(a, new HashSet<Integer>());
            if(! graph.containsKey(b)) graph.put(b, new HashSet<Integer>());
            graph.get(b).add(a);
            graph.get(a).add(b);
            j++;
        }
        while(! hi.isEmpty()) {
            int temp = hi.remove();
            if(graph.containsKey(temp)) {
                for(int i: graph.get(temp)) {
                    if( scores[i] == Integer.MAX_VALUE) {
                        scores[i] = scores[temp] + 1;
                        hi.add(i);
                    }
                }
            }
        }
        int output = 0;
        int max = 0;
        for(int i = 0; i < movie_num; i++) {
            if( scores[i] > max) {
                max = scores[i];
                output = i;
            }
        }
        System.out.println(output);
    }
}
