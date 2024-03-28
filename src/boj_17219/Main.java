package boj_17219;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, String> check = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			check.put(sc.next(), sc.next());
		}

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			System.out.println(check.get(str));
		}

	}

}
