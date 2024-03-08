import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이순으로 비교
                int result = Integer.compare(s1.length(), s2.length());
                if (result == 0) {
                    // 길이가 같으면 사전순으로 비교
                    return s1.compareTo(s2);
                }
                return result;
            }
        });

        // 중복 제거 및 정렬된 배열 출력
        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
