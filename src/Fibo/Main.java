package Fibo;

import java.util.Scanner;

public class Main {

	static Integer[][] D = new Integer[41][2];

	static Integer[] fibo(int N) {
		if (D[N][0] == null || D[N][1] == null) {
			D[N][0] = fibo(N - 1)[0] + fibo(N - 2)[0];
			D[N][1] = fibo(N - 1)[1] + fibo(N - 2)[1];
		}
		return D[N];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		D[0][0] = 1;
		D[0][1] = 0;
		D[1][0] = 0;
		D[1][1] = 1;

		int T = sc.nextInt();

		while (T-- > 0) {
			int N = sc.nextInt();

			fibo(N);

			System.out.println(D[N][0] + " " + D[N][1]);

		}

	}

}
