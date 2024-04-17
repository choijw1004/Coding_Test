import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int win = sc.nextInt();

		int Z = win / N;

		int ans = 0;

		for (int i = 1;; i++) {
			if (Z != (win + i) / N) {
				ans = i;
				break;
			}
			if (i == N) {
				ans = -1;
				break;
			}
		}
		System.out.println(ans);

	}
}
