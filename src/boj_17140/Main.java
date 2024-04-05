package boj_17140;

import java.util.Scanner;

public class Main {
	static int targetR, targetC, targetVal, time;

	// 1이면 R연산, 0이면 C연산
	static int calcuDirection(int[][] arr) {
		int rCnt = 0;
		int cCnt = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				break;
			}
			rCnt++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[0][i] == 0) {
				break;
			}
			cCnt++;
		}

		if (rCnt >= cCnt) {
			return 1;
		} else
			return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		targetR = sc.nextInt();
		targetC = sc.nextInt();
		targetVal = sc.nextInt();
		time = 0;

		boolean successFlag = false;

		while (true) {
			if (time == 100) {
				break;
			}
		}
	}
}
