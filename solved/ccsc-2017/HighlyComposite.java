import java.util.*;

public class HighlyComposite {
    private static final int MAGIC = 720721;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> compositeNumbers = new ArrayList<>();

        int max = 0;
        int[] divisors = new int[MAGIC];
        for (int i = 1; i < divisors.length; i++) {
            for (int j = i; j < divisors.length; j += i) {
                divisors[j]++;
            }
            if (divisors[i] > max) {
                max = divisors[i];
                compositeNumbers.add(i);
            }
        }

        // for (int i = 0; i < 20; i++) {
        //     System.out.println(i + " " + divisors[i]);
        // }

        // for (Integer n : compositeNumbers) {
        //     System.out.println(n);
        // }

        int numTestCases = in.nextInt();
        for (int tc = 0; tc < numTestCases; tc++) {
            int n = in.nextInt();

            if (compositeNumbers.contains(n)) {
                System.out.println(n);
            } else {
                int i = 0;
                while (n > compositeNumbers.get(i)) i++;

                System.out.println(compositeNumbers.get(i-1) + " "
                                   + compositeNumbers.get(i));
            }
        }
    }
}
