import java.util.Arrays;
import java.util.Scanner;

public class colors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Nshop = in.nextInt();
		int Njoe = in.nextInt();
		int shopColors[] = new int[Nshop];
		int joeColors[] = new int[Njoe];
		for (int i = 0; i < Nshop; i++) {
			shopColors[i] = in.nextInt();
		}
		for (int i = 0; i < joeColors.length; i++) {
			joeColors[i] = in.nextInt();
		}
		Arrays.sort(shopColors);
		Arrays.sort(joeColors);
		
		long waste = 0;
		int j = 0;
		
		for (int i = 0; i < joeColors.length; i++) {
			boolean go = true;
			while(go) {
				if(shopColors[j] >= joeColors[i]) {
					waste += shopColors[j] - joeColors[i];
					go = false;
				}else {
					j ++;
				}
			}
		}
		System.out.print(waste);
  	}
}
