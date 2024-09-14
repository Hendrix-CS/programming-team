public class Combinatorics {

    public static long choose(int n, int k) {
        if (n < 0 || k < 0 || k > n) return 0;

        k = Math.min(k,n-k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n-i+1) / i;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int n = 0; n < 100; n++) {
            for (int k = 0; k <= n; k++) {
                System.out.print(choose(n,k) + " ");
            }
            System.out.println();
        }
    }
}
