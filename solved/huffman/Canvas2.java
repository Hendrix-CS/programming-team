import java.util.*;

public class Canvas2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = in.nextInt();

            int[] sz = new int[N];
            for (int c = 0; c < N; c++) {
                sz[c] = in.nextInt();
            }

            PriorityQueue<HTree> trees = new PriorityQueue<>();

            for (int c = 0; c < N; c++) {
                trees.add(new HTree(sz[c]));
            }

            while (trees.size() > 1) {
                HTree t1 = trees.poll();
                HTree t2 = trees.poll();

                trees.add(new HTree(t1, t2));
            }

            System.out.println(trees.poll().totalCost);
        }
    }
}

class HTree implements Comparable<HTree> {
    public long cost, totalCost;
    public HTree left, right;

    public HTree(long cost) {
        this.cost = cost;
        totalCost = 0;
    }

    public HTree(HTree left, HTree right) {
        cost = left.cost + right.cost;
        totalCost = cost + left.totalCost + right.totalCost;

        this.left = left;
        this.right = right;
    }

    public int compareTo( HTree other ) {
        if (cost < other.cost) {
            return -1;
        } else if (cost == other.cost) {
            return 0;
        } else {
            return 1;
        }
    }
}
