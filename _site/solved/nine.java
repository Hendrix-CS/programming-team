package kattis2;

import java.math.BigInteger;
import java.util.Scanner;

public class nine {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		long m = 1000000007;
		for(int i = 0; i < testcases; i++) {
			long digit = in.nextLong() - 1;
			long answer = modexp(9, digit, 1000000007) * 8;
			System.out.println(answer % m);
		}
	}
	
	public static long modexp(long b, long e, long m) {
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1) res = (res * b) % m; // include current power of b?
				b = (b * b) % m; // square to get next power of b
				e >>= 1; // shift out rightmost bit of e
			}
		return res;
		}

}
