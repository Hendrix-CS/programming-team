public class AdjPQTest {
    public static void main(String[] args) {
        int[] arr = new int[] {3,8,2,5,6,1,0,31,77,35,18,14,34,90};
        AdjustablePQ<Integer> pq = new AdjustablePQ<>((i,j) -> arr[i] - arr[j]);
        for (int i = 0; i < arr.length; i++) {
            pq.add(i);
        }

        arr[6] = 12;
        pq.adjust(6);
        arr[8] = 20;
        pq.adjust(8);

        while (!pq.isEmpty()) {
            int i = pq.remove();
            System.out.println(i + " " + arr[i]);
        }
    }
}
