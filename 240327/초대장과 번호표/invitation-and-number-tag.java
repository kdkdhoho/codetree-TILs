import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int g = sc.nextInt();

        List<List<Integer>> groupsIncludedPerson = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            groupsIncludedPerson.add(new ArrayList<>());
        }

        List<HashSet<Integer>> notInvitedPeopleByGroup = new ArrayList();
        for (int i = 0; i < g; i++) {
            notInvitedPeopleByGroup.add(new HashSet<>());
        }

        for (int i = 0; i < g; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int person = sc.nextInt() - 1;
                HashSet<Integer> notInvitedPeople = notInvitedPeopleByGroup.get(i);
                notInvitedPeople.add(person);

                List<Integer> groupIncludedPerson = groupsIncludedPerson.get(person);
                groupIncludedPerson.add(i);
            }
        }

        int answer = 0;
        boolean[] invited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int person = q.poll();
            answer++;

            List<Integer> groupIncludedPerson = groupsIncludedPerson.get(person);
            for (int i = 0; i < groupIncludedPerson.size(); i++) {
                int group = groupIncludedPerson.get(i);

                HashSet<Integer> notInvitedPeople = notInvitedPeopleByGroup.get(group);
                notInvitedPeople.remove(person);

                // 초대받지 못한 사람이 1명이라면 초대한다.
                if (notInvitedPeople.size() == 1) {
                    int remainPerson = new ArrayList<>(notInvitedPeople).get(0);
                    if (!invited[remainPerson]) {
                        invited[remainPerson] = true;
                        q.add(remainPerson);
                    }
                }
            }
        }

        System.out.print(answer);
    }
}