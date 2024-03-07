import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int target = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n< target) {
				System.out.print(n+ " ");
			}

		}
	}
}
