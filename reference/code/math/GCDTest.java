public class GCDTest {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                boolean ok = true;
                long g = GCD.gcd(i,j);
                if (i % g != 0 || j % g != 0) ok = false;
                for (long d = g+1; d <= i && d <= j; d++) {
                    if (i % d == 0 && j % d == 0) ok = false;
                }
                if (!ok) System.out.println(g + " != gcd(" + i + ", " + j + ")");
            }
        }

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                boolean ok = true;
                EGCD e = GCD.egcd(i,j);
                if (i % e.g != 0 || j % e.g != 0) ok = false;
                for (long d = e.g+1; d <= i && d <= j; d++) {
                    if (i % d == 0 && j % d == 0) ok = false;
                }
                if (!ok) System.out.println(e.g + " != gcd(" + i + ", " + j + ")");
                if (e.x * i + e.y * j != e.g)
                    System.out.println("egcd failed for " + i + " " + j);
            }
        }
    }
}
