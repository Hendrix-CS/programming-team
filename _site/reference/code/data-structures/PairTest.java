import java.util.*;

public class PairTest {
    public static void main(String[] args) {
        Pair<Integer, String> p = new Pair<>(35, "hello");
        System.out.println(p);

        HashSet<Pair<Integer, String>> s = new HashSet<>();
        s.add(p);
        s.add(new Pair<Integer, String>(66, "box"));
        s.add(new Pair<Integer, String>(66, "box"));
        System.out.println(s.size() == 2 ? "OK" : "o noes");
        System.out.println(s.contains(p) ? "OK" : "o noes");
        System.out.println(!s.contains(new Pair<Integer, String>(65, "box")) ? "OK" : "o noes");

        TreeSet<CPair<Integer, String>> t = new TreeSet<>();
        t.add(new CPair<Integer, String>(20, "fox"));
        t.add(new CPair<Integer, String>(20, "box"));
        t.add(new CPair<Integer, String>(19, "fox"));
        t.add(new CPair<Integer, String>(33, "abc"));
        t.add(new CPair<Integer, String>(20, "fog"));

        for (CPair<Integer, String> pair : t) {
            System.out.println(pair);
        }
    }
}
