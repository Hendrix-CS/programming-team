import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Succession {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, HashSet<String>> family = new HashMap<>();
		HashMap<String, Integer> inDegree = new HashMap<>();
		
		int nRel = in.nextInt();
		int nClim = in.nextInt();
		String King = in.next();

		HashMap<String, Double> scores = new HashMap<>();
		for(int i = 0; i < nRel; i++) {
			String Child = in.next();
			String Parent1 = in.next();
			String Parent2 = in.next();

			if(!family.containsKey(Parent1)) {
				family.put(Parent1, new HashSet<String>());
			}
			family.get(Parent1).add(Child);

			if(!family.containsKey(Parent2)) {
				family.put(Parent2, new HashSet<String>());
			}
			family.get(Parent2).add(Child);

			inDegree.put(Child, 2);
		}

		Stack<String> curNodes = new Stack<>();
		ArrayList<String> Topsort = new ArrayList<>();
		for( String entry: family.keySet()) {
			if(!inDegree.containsKey(entry)) {
				curNodes.add(entry);
			}
		}

		while(!curNodes.isEmpty()) {
			String TemPnode = curNodes.pop();
			Topsort.add(TemPnode);
			if (family.containsKey(TemPnode)) {
				for(String node: family.get(TemPnode)) {
					inDegree.replace(node, inDegree.get(node) - 1);
					if (inDegree.get(node) == 0) {
						curNodes.push(node);
					}
				}
			}

		}

		scores.put(King, (double) 1);

		for(String s: Topsort) {
			HashSet<String> c = family.get(s);
			if (!scores.containsKey(s)) scores.put(s, 0D);
			if(family.containsKey(s)) {
				for (String child:c) {
					if (!scores.containsKey(child)) scores.put(child, 0D);
					scores.replace(child, scores.get(child)+scores.get(s)/2);
				}
			}
		}


		Double maxB= -10D;
		String bestClaimant = "";
		for (int i = 0; i < nClim; i++) {
			String name = in.next();
			Double n = (scores.containsKey(name))?scores.get(name):0D;
			if (n >= maxB) {
				maxB=n;
				bestClaimant=name;
			}	

		}
		
		System.out.print(bestClaimant);
	}
}
