package Week4_Assignment_MiniProject;
import java.util.*;

class Edge {
    int destination;
    int weight;

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int city;
    int distance;

    Node(int city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class MiniProject_CityPathFinder {

    static void shortestPath(List<List<Edge>> graph, int source, int destination) {

        int n = graph.size();
        int[] dist = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[source] = 0;
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();
            int city = current.city;

            for (Edge edge : graph.get(city)) {

                int newDist = dist[city] + edge.weight;

                if (newDist < dist[edge.destination]) {

                    dist[edge.destination] = newDist;
                    parent[edge.destination] = city;

                    pq.add(new Node(edge.destination, newDist));
                }
            }
        }

        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path exists.");
            return;
        }

        System.out.println("Shortest Distance = " + dist[destination]);

        List<Integer> path = new ArrayList<>();

        for (int v = destination; v != -1; v = parent[v]) {
            path.add(v);
        }

        Collections.reverse(path);

        System.out.print("Path: ");

        for (int city : path) {
            System.out.print(city + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int cities = sc.nextInt();

        System.out.print("Enter number of roads: ");
        int roads = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < cities; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter source destination distance:");

        for (int i = 0; i < roads; i++) {

            int src = sc.nextInt();
            int dest = sc.nextInt();
            int distance = sc.nextInt();

            graph.get(src).add(new Edge(dest, distance));
            graph.get(dest).add(new Edge(src, distance));
        }

        System.out.print("Enter source city: ");
        int source = sc.nextInt();

        System.out.print("Enter destination city: ");
        int destination = sc.nextInt();

        shortestPath(graph, source, destination);

        sc.close();
    }
}
