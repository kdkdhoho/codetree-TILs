/**
1번부터 N번까지의 사람이 있다.
그룹은 G개가 있다.

한 사람이 여러 그룹에 속할 수 있다.
그룹 내 모든 멤버가 서로 정확히 일치하는 그룹은 없다.
그룹의 인원수는 그룹마다 상이하다.

그룹 인원수가 k인 그룹에서, k-1명의 사람들이 초대장을 받았다면, 나머지 한 사람도 무조건 초대장을 받는다.
1번 사람에게는 무조건 초대장을 준다고 할 때, 초대장을 받는 사람의 수는?
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int g = sc.nextInt();

        Map<Integer, List<Integer>> groupsByPerson = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            groupsByPerson.put(i, new ArrayList<>());
        }

        Map<Integer, Set<Integer>> notInvitedPeopleByGroup = new HashMap<>();
        for (int i = 1; i <= g; i++) {
            notInvitedPeopleByGroup.put(i, new HashSet<>());
        }

        for (int i = 1; i <= g; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int person = sc.nextInt();

                List<Integer> group = groupsByPerson.get(person);
                group.add(i);

                Set<Integer> notInvitedPeople = notInvitedPeopleByGroup.get(i);
                notInvitedPeople.add(person);
            }
        }

        int answer = 0;
        boolean[] invited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        invited[1] = true;

        while (!q.isEmpty()) {
            int person = q.poll();
            answer++;

            List<Integer> group = groupsByPerson.get(person);
            for (int groupNumber : group) {
                Set<Integer> notInvitedPeople = notInvitedPeopleByGroup.get(groupNumber);
                notInvitedPeople.remove(person);

                if (notInvitedPeople.size() == 1) {
                    int remainPerson = new ArrayList<>(notInvitedPeople).get(0);
                    if (!invited[remainPerson]) {
                        q.add(remainPerson);
                        invited[remainPerson] = true;
                    }
                }
            }
        }

        System.out.print(answer);
    }
}