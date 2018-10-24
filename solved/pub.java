import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

public class pub {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nodes = in.nextInt();
		int ways = in.nextInt();
		HashMap<Integer, HashSet<Integer>> data = new HashMap<>();
		int a = 0;
		int b = 0;
		for (int i = 0; i < ways; i++) {
			a = in.nextInt();
			b = in.nextInt();
			if(!data.containsKey(a)) {
				data.put(a,new HashSet<>());
			}
			data.get(a).add(b);

			if(!data.containsKey(b)) {
				data.put(b,new HashSet<>());
			}
			data.get(b).add(a);
		}
		
		for (int i = 1; i <= nodes; i++) {
			if (!data.containsKey(i)) {
				System.out.println("Impossible");
				System.exit(0);
			}
		}
		

		boolean[] ispub =  new boolean[nodes + 1];
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> workNodes= new ArrayDeque();
		
		for (int i = 1; i < ispub.length; i++) {
			if(!visited.contains(i)) {
				visited.add(i);
				workNodes.add(i);
				int Tnode = 0;
				while(!workNodes.isEmpty()) {
					Tnode = workNodes.remove();
					for(Integer e: data.get(Tnode)) {
						if (!visited.contains(e)) {
							ispub[e] = !ispub[Tnode];
							workNodes.add(e);
							visited.add(e);
						}
					}
				}
			}
		}
		
		
		for (int i = 1; i < ispub.length; i++) {
			System.out.println(ispub[i] ? "pub": "house" );
		}

	}
}


