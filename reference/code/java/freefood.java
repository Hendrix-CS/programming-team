package kattis2;
import java.util.*;

public class freefood {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// HashSet used in case of overlapping event days
		HashSet days = new HashSet();
		// Get number of events
		int events = in.nextInt();
		for (int i = 0; i < events; i++) {
			int first = in.nextInt();
			int last = in.nextInt();
			// Add days of event to the HashSet
			for (int j = first; j <= last; j++) {
				days.add(j);
			}
		}
		// Number of days that you can get free food
		System.out.println(days.size());
	}
}
