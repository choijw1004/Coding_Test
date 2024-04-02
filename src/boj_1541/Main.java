package boj_1541;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		int sum = 0;
		boolean minusMode = false;

		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		sb.append("");
		for (int i = 0; i < line.length(); i++) {

			if (line.charAt(i) == '-') {
				minusMode = true;
				plus.add(Integer.parseInt(sb.toString()));
				sb.setLength(0);
			} else if (line.charAt(i) == '+') {
				if (minusMode == true) {
					minus.add(Integer.parseInt(sb.toString()));
					sb.setLength(0);
				} else {
					plus.add(Integer.parseInt(sb.toString()));
					sb.setLength(0);
				}
			} else {
				sb.append(line.charAt(i));
			}

		}
		if (minusMode == true) {
			minus.add(Integer.parseInt(sb.toString()));
		} else
			plus.add(Integer.parseInt(sb.toString()));
		for (int x : plus) {
			sum += x;
			System.out.println(x);
		}
		System.out.println();
		for (int x : minus) {
			sum -= x;
			System.out.println(x);
		}

		System.out.println(sum);

	}
}