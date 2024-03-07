package boj_1620;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		List<String> name = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			name.add(sc.next());
		}

		for (int i = 0; i < M; i++) {
			String s = sc.next();
			if (Character.isDigit(s.charAt(0))) {
				System.out.println(name.get(Integer.parseInt(s) - 1));
			} else {
				for (int j = 0; j < N; j++) {
					if (name.get(j).equals(s)) {
						System.out.println(j + 1);
						break;
					}
				}
			}
		}
	}
}
