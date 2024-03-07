package boj_2751;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> numArr = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (numArr.contains(num)) {
				continue;
			} else
				numArr.add(num);
		}
		
		Collections.sort(numArr);

		for (int i = 0; i < numArr.size(); i++) {
			System.out.println(numArr.get(i));
		}

	}

}
