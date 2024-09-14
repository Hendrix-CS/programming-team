import java.util.*;
public class PrefixSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read array
        int n = in.nextInt();
        int[] A = new int[n+1];
        for (int i = 1; i <= n; i++) {
            A[i] = in.nextInt();
        }

        // Do prefix scan
        int[] P = new int[n+1];
        for (int i = 1; i <= n; i++) {
            P[i] = P[i-1] + A[i];
        }

        // Answer queries
        int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            int i = in.nextInt(), j = in.nextInt();
            System.out.println(P[j] - P[i-1]);
        }
    }
}
