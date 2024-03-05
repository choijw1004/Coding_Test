package boj_9012;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            String str = sc.nextLine();

            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

}
