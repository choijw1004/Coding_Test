package boj_6497;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static int V, E;
	static int[] parent;
	static int finalCost;
	static int checkSum;
	static int i;

	static int find(int x) {
		while (x != parent[x]) {
			x = parent[x];
		}
		return x;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			if (V == 0 && E == 0) {
				break;
			}
			graph = new int[E][3];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				graph[i][0] = N;
				graph[i][1] = M;
				graph[i][2] = K;
			}

			Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

			parent = new int[V];
			finalCost = 0;

			for (int j = 0; j < V; j++) {
				parent[j] = j;
			}

			for (int j = 0; j < E; j++) {
				if (find(graph[j][0]) != find(graph[j][1])) {
					union(graph[j][0], graph[j][1]);
					finalCost += graph[j][2];
				}
			}

			checkSum = 0;
			for (int j = 0; j < E; j++) {
				checkSum += graph[j][2];
			}

			bw.write(checkSum - finalCost + "\n");
//			System.out.println(checkSum - finalCost);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
