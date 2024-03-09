import java.util.*;

/**
A랑 B가 게임한다.
게임 점수가 바뀔 때마다 점수가 1등인 사람들을 모아서 명예의 전당에 이름을 올린다.

점수 변동 관련 정보가 주어졌을 때, 명예의 전당에 올라간 사람의 조합이 총 몇 번 바뀌는지 출력하시오.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        boolean[] winner = {true, true};

        int scoreA = 0;
        int scoreB = 0;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String player = sc.next();
            int score = sc.nextInt();

            if (player.equals("A")) {
                scoreA += score;
            }
            if (player.equals("B")) {
                scoreB += score;
            }

            boolean[] newWinner = new boolean[2];
            if (scoreA > scoreB) {
                newWinner[0] = true;
                newWinner[1] = false;
            }
            if (scoreA < scoreB) {
                newWinner[0] = false;
                newWinner[1] = true;
            }
            if (scoreA == scoreB) {
                newWinner[0] = true;
                newWinner[1] = true;
            }

            for (int j = 0; j < 2; j++) {
                if (winner[j] != newWinner[j]) {
                    winner = newWinner;
                    answer++;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}