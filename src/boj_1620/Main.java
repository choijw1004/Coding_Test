package boj_1620;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, Integer> pocketMon = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            pocketMon.put(sc.next(), i);
        }

        for (int i = 0; i < M; i++) {
            String str = sc.next();

            if (isInteger(str)) {
                int num = Integer.parseInt(str);
                for (String key : pocketMon.keySet()) {
                    if (pocketMon.get(key) == num) {
                        System.out.println(key);
                        break;
                    }
                }
            } else {
                System.out.println(pocketMon.get(str));
            }
        }
    }
}
