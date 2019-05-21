public class LIS {

    // O(n lg n) Longest Increasing Subsequence
    public static int[] LIS(int[] arr) {

        if (arr.length == 0) return new int[0];

        // prev[i] stores the index of the previous element in a LIS
        // ending at arr[i]
        int[] prev = new int[arr.length];

        // downravel[i] stores the index of the last (smallest)
        // element of the ith descreasing subsequence in an optimal
        // downravel.  The elements of arr represented by downravel
        // are always sorted in increasing order.  At each step, we
        // find the smallest element of downravel which is >= arr[i]
        // (via binary search) and replace it with arr[i].
        ArrayList<Integer> downravel = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int opt = 0, lo = 1, hi = downravel.size();
            while (lo <= hi) {
                int mid = (lo + hi)/2;

                // For longest *non-decreasing* sequence, change < to <=
                if (arr[downravel.get(mid-1)] < arr[i]) {
                    opt = mid; lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (opt < downravel.size()) downravel.set(opt, i);
            else downravel.add(i);

            prev[i] = opt == 0 ? -1 : downravel.get(opt-1);
        }

        // Now just follow prev pointers from the last element.
        int[] incseq = new int[downravel.size()];
        int j = downravel.size() - 1, cur = downravel.get(j);
        while (cur != -1) {
            incseq[j] = cur; cur = prev[cur]; j--;
        }

        return incseq;
    }
}
