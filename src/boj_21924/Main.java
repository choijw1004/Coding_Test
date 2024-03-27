package boj_21924;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] graph;
	static int V, E;
	static int[] parent;
	static int finalCost;

	// union

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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		parent = new int[V];

		graph = new int[E][3];

		for (int i = 0; i < E; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}

		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
				union(graph[i][0] - 1, graph[i][1] - 1);
				finalCost += graph[i][2];
				continue;
			}
		}
		int checkSum = 0;
		for (int i = 0; i < E; i++) {
			checkSum += graph[i][2];
		}

		List<Integer> checkArr = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			if (checkArr.contains(find(i) + 1)) {
				continue;
			} else
				checkArr.add(find(i) + 1);
		}

		if (checkArr.size() >= 1) {
			System.out.println(-1);
		} else
			System.out.println(checkSum - finalCost);

	}

}
