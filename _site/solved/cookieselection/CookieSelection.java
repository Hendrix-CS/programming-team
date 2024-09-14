import java.util.*;

public class CookieSelection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeBag<Integer> minBag = new TreeBag<Integer>();
        TreeBag<Integer> maxBag = new TreeBag<Integer>();
        // invariant: either minBag.size == maxBag.size
        // or maxBag is one larger

        while (in.hasNext()) {
            String c = in.nextLine();
            if (c.equals("#")) {
                System.out.println(maxBag.pollFirst());
            } else {
                int diameter = Integer.parseInt(c);
                if (maxBag.isEmpty() || diameter >= maxBag.first())
                    maxBag.add(diameter);
                else
                    minBag.add(diameter);
            }

            if (minBag.size() > maxBag.size()) {
                maxBag.add(minBag.pollLast());
            } else if (maxBag.size() > minBag.size() + 1) {
                minBag.add(maxBag.pollFirst());
            }
        }
    }
}
