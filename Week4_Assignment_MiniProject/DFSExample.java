package Week4_Assignment_MiniProject;
import java.util.*;

public class DFSExample {

    static void dfs(ArrayList<ArrayList<Integer>> graph,
                    int node,
                    boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        System.out.println("Enter edges:");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[v];

        System.out.println("DFS Traversal:");
        dfs(graph, start, visited);

        sc.close();
    }
}
