package boj_2231;

import java.util.Scanner;

public class Main {

	static int checkSum(int num) {
		String str = Integer.toString(num);
		int sum = num; // 자기 자신을 먼저 더해주고
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i)); // 각 자리수를 더해줌
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = Math.max(1, n - 54); // 최소 생성자는 1부터 시작하고, 생성자의 합은 최대 54이므로
		while (true) {
			if (i >= n) { // 생성자가 없는 경우
				System.out.println(0);
				break;
			}
			if (checkSum(i) == n) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
}
