package moviemarathons;

import java.util.Scanner;

public class moviecounts {
	public static void main(String ags[]) {
		Scanner in = new Scanner(System.in);
		int testcases =  in.nextInt();

		for (int i = 0; i < testcases; i++) {
			int numMovies = in.nextInt();
			int marathonTime = in.nextInt();
			int movies[] = new int[numMovies];
			for (int j = 0; j < numMovies; j++) {
				movies[j] = in.nextInt();
			}
			int count = 0;
			// powerset solution
			for (int j = 0; j < Math.pow(2, numMovies); j++) {
				int current = 0;
				for (int s = 0; s < numMovies; s++) {
					if ((j & (1 << s)) != 0) {
						current += movies[s];
					}
				}
				if (current == marathonTime) {
					count += 1;
				}
				
			}
			System.out.println(count);
			
			// dynamic programming solution
			// make double array of bools
			// for each num movies 
				// for each minute
					// 
		}
	}

}
