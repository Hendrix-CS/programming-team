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
    }
}
