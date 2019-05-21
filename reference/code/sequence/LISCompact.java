public class LIS {
    public static int[] LIS(int[] arr) {
        if (arr.length == 0) return new int[0];
        int[] prev = new int[arr.length];
        ArrayList<Integer> downravel = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int opt = 0, lo = 1, hi = downravel.size();
            while (lo <= hi) {
                int mid = (lo + hi)/2;

                // For longest *non-decreasing* sequence, change < to <=
                if (arr[downravel.get(mid-1)] < arr[i]) { opt = mid; lo = mid + 1; }
                else { hi = mid - 1; }
            }

            if (opt < downravel.size()) downravel.set(opt, i);
            else downravel.add(i);
            prev[i] = opt == 0 ? -1 : downravel.get(opt-1);
        }

        int[] incseq = new int[downravel.size()];
        int j = downravel.size() - 1, cur = downravel.get(j);
        while (cur != -1) { incseq[j] = cur; cur = prev[cur]; j--; }
        return incseq;
    }
}
