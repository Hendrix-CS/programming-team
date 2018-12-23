public class RationalTest {
    public static void main(String[] args) {
        Rational r = new Rational(12, -18);

        boolean ok = true;
        ok = ok && (r.toString().equals("-2/3"));
        ok = ok && (new Rational(2, 3).plus(new Rational(4,3)).toString().equals("2"));
        ok = ok && (r.plus(new Rational(5, 7)).equals(new Rational(1, 21)));

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                for (int k = 1; k <= 20; k++) {
                    for (int l = 1; l <= 20; l++) {
                        Rational r1 = new Rational(i,j);
                        Rational r2 = new Rational(k,l);
                        ok = ok && (r1.compareTo(r1.plus(r2)) < 0);
                        ok = ok && (r1.plus(r2).equals(r2.plus(r1)));
                        ok = ok && (r1.plus(r2).minus(r1).equals(r2));
                    }
                }
            }
        }

        System.out.println(ok ? "OK!" : "Error!");
    }
}
