package boj_1764;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		String[] noD = new String[N];

		for (int i = 0; i < N; i++) {
			noD[i] = sc.next();
		}

		String[] noH = new String[M];

		for (int i = 0; i < M; i++) {
			noH[i] = sc.next();
		}

		List<String> targetArr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (noD[i].equals(noH[j])) {
					targetArr.add(noD[i]);
				}
			}
		}

		Collections.sort(targetArr);
		
		System.out.println(targetArr.size());
		for (int i = 0; i < targetArr.size(); i++) {
			System.out.println(targetArr.get(i));
		}

	}

}
