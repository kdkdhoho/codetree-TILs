/**
n*m 크기 배열에 정수가 하나씩 있다.
이 영역 안에서, 가능한 양수 직사각형 중 최대 크기를 구한다.

양수 직사각형: 직사각형의 변들이 주어진 격자판에 평행하면서, 직사각형 내에 있는 숫자들이 전부 양수인 직사각형.

최대 크기의 양수 직사각형을 찾으시오.

크기는 직사각형의 가로x세로이다.

- 가로, 세로 최소 1에서 최대 20
- 정수값은 -1000에서 1000

*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        int answer = -1;
        for (int row1 = 0; row1 < n; row1++) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int row2 = row1; row2 < n; row2++) {
                    for (int col2 = col1; col2 < m; col2++) {
                        for (int row = row1; row <= row2; row++) {
                            boolean isCond = true;
                            for (int col = col1; col <= col2; col++) {
                                if (arr[row][col] < 0) {
                                    isCond = false;
                                    break;
                                }
                            }

                            if (isCond) {
                                int area = (int)(((row2-row1)+1) * ((col2-col1)+1));
                                answer = Math.max(answer, area);
                            }
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }
}