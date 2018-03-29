import java.util.Scanner;

public class Mordor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for(int test = 0; test < testcases; test++) {
			int rows = in.nextInt();
			int cols = in.nextInt();
			int[][] map = new int[cols][rows];
			int[][] dist = new int[cols][rows];
			for(int r=0; r < rows; r++) {
				for(int c = 0; c < cols; c++) {
					map[c][r] = in.nextInt();
				}
			}
			for(int c = cols - 2; c >= 0; c--) {
				for(int r=0; r < rows; r++) {
					int min = Math.abs(map[c][r] - map[c + 1][r]) + dist[c + 1][r];
					if( r > 0) {
						int temp =  Math.abs(map[c][r] - map[c + 1][r - 1]) +
								dist[c + 1][r - 1];
						min = Math.min(min, temp);
					}
					if(r < rows - 1) {
						int temp =  Math.abs(map[c][r] - map[c + 1][r + 1]) +
								dist[c + 1][r + 1];
						min = Math.min(min, temp);
					}
					dist[c][r] = min;
				}
			}
			int flattest = dist[0][0];
			for(int r = 1; r < rows; r++) {
				flattest = Math.min(flattest, dist[0][r]);
			}
			System.out.println(flattest);
		}
	}
}
