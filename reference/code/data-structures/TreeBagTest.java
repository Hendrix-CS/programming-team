public class TreeBagTest {
    public static void main(String[] args) {
        boolean ok = true;

        TreeBag<String> t = new TreeBag<>();
        t.add("hello");
        t.add("world");
        t.add("hello");

        ok = ok && (t.size() == 3);
        t.remove("world");
        ok = ok && (t.size() == 2);
        t.remove("hello");
        ok = ok && (t.size() == 1);

        t.add("hello"); t.add("world"); t.add("hello"); t.add("foo"); t.add("world");

        String[] correct = new String[] { "foo", "hello", "hello", "hello", "world", "world" };

        int i = 0;
        for (String s : t) {
            ok = ok && s.equals(correct[i++]);
        }

        ok = ok && t.count("hello") == 3;
        ok = ok && t.count("world") == 2;
        ok = ok && t.count("foo") == 1;
        ok = ok && t.count("bar") == 0;

        System.out.println(ok ? "OK!" : "Error!");
    }
}
