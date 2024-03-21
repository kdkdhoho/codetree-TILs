import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_DISTANCE = 3000000;

    public static void main(String[] args) {
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int startVertex = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vertexCount + 1];

//        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int v = 1; v <= vertexCount; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            int vertexA = sc.nextInt();
            int vertexB = sc.nextInt();
            int weight = sc.nextInt();

            graph[vertexA].add(new Edge(vertexB, weight));
            graph[vertexB].add(new Edge(vertexA, weight));

//            List<Edge> edgesA = graph.get(vertexA);
//            edgesA.add(new Edge(vertexB, weight));
//            graph.put(vertexA, edgesA);
//
//            List<Edge> edgesB = graph.get(vertexB);
//            edgesB.add(new Edge(vertexA, weight));
//            graph.put(vertexB, edgesB);
        }

        int[] dist = new int[vertexCount + 1];
        Arrays.fill(dist, MAX_DISTANCE);
        dist[startVertex] = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>(comparingInt(e -> e.distance));
        pq.add(new Element(startVertex, 0));

        while (!pq.isEmpty()) {
            Element element = pq.poll();
            int minVertex = element.vertex;
            int minDistance = element.distance;

            if (minDistance != dist[minVertex]) {
                continue;
            }

//            List<Edge> edges = graph.get(minVertex);
            List<Edge> edges = graph[minVertex];
            for (Edge edge : edges) {
                int targetVertex = edge.vertex;
                int targetWeight = edge.weight;

                int newDist = minDistance + targetWeight;
                if (newDist < dist[targetVertex]) {
                    dist[targetVertex] = newDist;
                    pq.add(new Element(targetVertex, newDist));
                }
            }
        }

//        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= vertexCount; i++) {
            if (dist[i] == MAX_DISTANCE) {
//                answer.append(-1).append("\n");
                System.out.println(-1);
            } else {
//                answer.append(dist[i]).append("\n");
                System.out.println(dist[i]);
            }
        }
//        System.out.print(answer);
    }
}

class Edge {
    int vertex, weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Element {
    int vertex, distance;

    public Element(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}