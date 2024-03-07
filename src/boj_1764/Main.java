package boj_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		ArrayList<String> noD = new ArrayList<>();
		ArrayList<String> noH = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			noD.add(br.readLine());
		}

		Collections.sort(noD);

		for (int i = 0; i < M; i++) {
			noH.add(br.readLine());
		}

		Collections.sort(noH);

		ArrayList<String> targetArr = new ArrayList<>();

		for (String s : noD) {
			if (Collections.binarySearch(noH, s) >= 0) {
				targetArr.add(s);
			}
		}

		Collections.sort(targetArr);

		System.out.println(targetArr.size());
		for (String s : targetArr) {
			System.out.println(s);
		}
	}
}
