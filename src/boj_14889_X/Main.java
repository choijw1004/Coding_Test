package boj_14889_X;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] board;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	static void makeTeam(int index, int count) {
		if (count == N / 2) {
			calculateDifference();
			return;
		}

		for (int i = index; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				makeTeam(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	static void calculateDifference() {
		int teamStart = 0;
		int teamLink = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) { // Start 팀인 경우
					teamStart += board[i][j] + board[j][i];
				} else if (!visited[i] && !visited[j]) { // Link 팀인 경우
					teamLink += board[i][j] + board[j][i];
				}
			}
		}

		int difference = Math.abs(teamStart - teamLink);

		if (difference < min) {
			min = difference;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int tc = 1;

		while (T-- > 0) {

			N = sc.nextInt();
			board = new int[N][N];
			visited = new boolean[N];
			min = 9999999;

			// 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			// 조합을 통해 팀 구성
			makeTeam(0, 0);

			System.out.println("#" + tc+ " " + min);
			tc++;
		}
	}

}
