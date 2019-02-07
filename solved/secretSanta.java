package kattis2;

import java.util.Scanner;

public class secretSanta {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double num = in.nextLong();
		double answer = 0;
		double fac = 1;
		int i = 0;
		// Code for derangements
		while(fac < 1000000000 && i < num) {
			answer += 1/fac;
			fac *= -(i+2);
			i++;
		}
		System.out.println(answer);
	}
}
