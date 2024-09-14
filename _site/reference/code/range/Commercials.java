import java.util.*;

public class Commercials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); int P = in.nextInt();

        int max = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            sum += in.nextInt() - P;
            if (sum < 0) sum = 0;      // or  sum = Math.max(sum, 0);
            if (sum > max) max = sum;  // or  max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
