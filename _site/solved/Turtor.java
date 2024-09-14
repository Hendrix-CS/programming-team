import java.util.Scanner;

public class Turtor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			int outsiders = 0;
			int prevPop = in.nextInt();
			int curPop = in.nextInt();
			
			while(curPop != 0) {
				outsiders += Math.max(0, curPop - prevPop*2);
				prevPop = curPop;
				curPop = in.nextInt();
			}
			
			System.out.println(outsiders);
		}
	}
	
}
