package boj_1197;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int V, E;
	static int[][] graph;
	static int[] parent;
	static int finalCost;

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else
			return find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b) {
			parent[a] = b;
		} else
			parent[b] = a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		graph = new int[E][3];

		for (int i = 0; i < E; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}

		parent = new int[V];

		finalCost = 0;

		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
				union(graph[i][0] - 1, graph[i][1] - 1);
				System.out.println(graph[i][2]);
				finalCost += graph[i][2];
				continue;
			}
		}
		System.out.println(finalCost);
	}
}
