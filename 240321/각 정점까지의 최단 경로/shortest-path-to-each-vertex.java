import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final int MAX_DISTANCE = 3000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int startVertex = sc.nextInt();

        ArrayList<Node>[] graph = new ArrayList[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            graph[i] = new ArrayList<>();
        }

        while (edgeCount-- > 0) {
            int vertexA = sc.nextInt();
            int vertexB = sc.nextInt();
            int weight = sc.nextInt();

            graph[vertexA].add(new Node(vertexB, weight));
            graph[vertexB].add(new Node(vertexA, weight));
        }

        int[] dist = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            dist[i] = MAX_DISTANCE;
        }
        dist[startVertex] = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(startVertex, 0));

        while (!pq.isEmpty()) {
            Element element = pq.poll();
            int vertex = element.vertex;
            int distance = element.distance;

            if (distance != dist[vertex]) {
                continue;
            }

            for (Node node : graph[vertex]) {
                int targetVertex = node.vertex;
                int targetWeight = node.weight;

                int newDist = dist[vertex] + targetWeight;
                if (newDist < dist[targetVertex]) {
                    dist[targetVertex] = newDist;
                    pq.add(new Element(targetVertex, newDist));
                }
            }
        }

        for (int i = 1; i <= vertexCount; i++) {
            if (dist[i] == MAX_DISTANCE)
                System.out.println(-1);
            else
                System.out.println(dist[i]);
        }
    }
}

class Node {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Element implements Comparable<Element> {
    int vertex, distance;

    public Element(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Element e) {
        return this.distance - e.distance;   // dist 기준 오름차순 정렬
    }
}