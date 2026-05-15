import java.util.*;

public class SocialNetworkTraversal {

    // ================= DFS =================

    static void dfs(int node,
                    boolean[] visited,
                    ArrayList<ArrayList<Integer>> graph) {

        visited[node] = true;

        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                dfs(neighbor, visited, graph);
            }
        }
    }

    // ================= BFS =================

    static void bfs(int start,
                    ArrayList<ArrayList<Integer>> graph,
                    int n) {

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;

        queue.offer(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.offer(neighbor);
                }
            }
        }
    }

    // ================= MAIN FUNCTION =================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {

            graph.add(new ArrayList<>());
        }

        System.out.print("Enter number of friendships: ");
        int edges = sc.nextInt();

        System.out.println("Enter user connections:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. DFS Traversal");
            System.out.println("2. BFS Traversal");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    boolean[] visited =
                            new boolean[n + 1];

                    System.out.println("DFS Traversal:");

                    dfs(1, visited, graph);

                    System.out.println();

                    break;

                case 2:

                    System.out.println("BFS Traversal:");

                    bfs(1, graph, n);

                    System.out.println();

                    break;

                case 3:

                    System.out.println("Program Ended");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}