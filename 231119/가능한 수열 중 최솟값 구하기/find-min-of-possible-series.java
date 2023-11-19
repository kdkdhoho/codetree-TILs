import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 길이가 n인 수열을 숫자 4, 5 6으로만 구성한다.
 * 이때, 임의의 길이를 갖는 두 개의 인접한 부분 수열이 동일한 경우, 이는 불가능한 수열이다.
 * 이때, 길이가 n인 가능한 수열 중, 앞에서부터 읽었을 때 사전순으로 가장 앞선 수열을 출력하시오.
 * <p>
 * 아이디어
 * 1) 일단 4, 5, 6으로 길이가 n인 모든 경우의 수열을 만든다.
 * 2) 만들어진 수열을, 아름다운 수인지 확인한다.
 * 3) 아름다운 수라면, 정답 리스트에 추가한다.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> answer = new ArrayList<>();

    private static int n;

    public static void main(String[] args) {
        n = sc.nextInt();

        recursive(new ArrayList<>(), n);
    }

    private static void recursive(List<Integer> numbers, int n) {
        if (numbers.size() == n) {
            if (isBeautiful(numbers)) {
                String result = numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""));
                System.out.println(result);
                System.exit(0);
            }
            return;
        }

        for (int num = 4; num <= 6; num++) {
            numbers.add(num);
            recursive(numbers, n);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static boolean isBeautiful(List<Integer> numbers) {
        for (int l = 1; l <= n / 2; l++) { // O(N/2)
            for (int start = 0; start <= n - (l * 2); start++) { // O(N/2)
                int cnt = 0;

                int end = start + l - 1;
                for (int i = start; i <= end; i++) { // O(N/2)
                    int idx = i + l;

                    if (numbers.get(i).equals(numbers.get(idx))) {
                        cnt++;
                    }
                }

                if (cnt == l) {
                    return false;
                }
            }
        }
        return true;
    }
}