package boj_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 누적 합을 계산하여 저장
		int[] prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}

		// 각 쿼리를 처리하고 결과를 StringBuilder에 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int sol = prefixSum[b] - prefixSum[a - 1];
			sb.append(sol).append("\n");
		}

		System.out.print(sb);
		br.close();
	}
}
