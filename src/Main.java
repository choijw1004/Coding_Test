import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] parent;

	// find
	static int find(int x) {
		while (x != parent[x]) {
			x = parent[x];
		}
		return x;
	}

	// union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			// 부모 배열
			parent = new int[V];
			for (int i = 0; i < V; i++) {
				parent[i] = i;
			}

			// 입력 받을 때 바로 union 
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				union(a, b);
			}

			// parent check 배열
			
			List<Integer> checkArr = new ArrayList<>();
			
			// 정점들 전부 돌면서 find -> checkArr에 없으면 add, if not -> continue
			
			for (int i = 0; i < V; i++) {
				if (checkArr.contains(find(i) + 1))
					continue;
				else
					checkArr.add(find(i) + 1);
			}

			System.out.println("#" + tc + " " + checkArr.size());

		}
	}
}
