package Week4_Assignment_MiniProject;
import java.util.*;

class Pair {
    int vertex, distance;

    Pair(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

public class DijkstraExample {

    public static void dijkstra(List<List<Pair>> graph, int source) {

        int n = graph.size();
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.distance - b.distance);

        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            for (Pair neighbor : graph.get(current.vertex)) {

                int newDist =
                        dist[current.vertex] + neighbor.distance;

                if (newDist < dist[neighbor.vertex]) {

                    dist[neighbor.vertex] = newDist;

                    pq.add(
                        new Pair(neighbor.vertex, newDist)
                    );
                }
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < n; i++) {
            System.out.println(source + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter edges: ");
        int e = sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        System.out.println("Enter source destination weight:");

        for (int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();

            graph.get(src).add(new Pair(dest, wt));
            graph.get(dest).add(new Pair(src, wt));
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        dijkstra(graph, source);

        sc.close();
    }
}
