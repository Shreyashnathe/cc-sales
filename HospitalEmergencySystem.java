import java.util.*;

public class HospitalEmergencySystem {

    // ================= DFS FUNCTION =================

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

    // ================= BFS SHORTEST PATH =================

    static void shortestPath(int start,
                             int destination,
                             ArrayList<ArrayList<Integer>> graph,
                             int n) {

        boolean[] visited = new boolean[n + 1];

        int[] parent = new int[n + 1];

        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;

        queue.offer(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    parent[neighbor] = node;

                    queue.offer(neighbor);
                }
            }
        }

        // ================= PATH NOT FOUND =================

        if (!visited[destination]) {

            System.out.println("\nNo Route Available");
            return;
        }

        // ================= RECONSTRUCT PATH =================

        ArrayList<Integer> path = new ArrayList<>();

        int current = destination;

        while (current != -1) {

            path.add(current);

            current = parent[current];
        }

        Collections.reverse(path);

        // ================= PRINT PATH =================

        System.out.println("\nShortest Emergency Route");

        for (int i = 0; i < path.size(); i++) {

            System.out.print(path.get(i));

            if (i != path.size() - 1) {

                System.out.print(" -> ");
            }
        }

        System.out.println();

        System.out.println("Minimum Departments Crossed : "
                + (path.size() - 1));
    }

    // ================= MAIN FUNCTION =================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println(" HOSPITAL EMERGENCY ROUTE SYSTEM ");
        System.out.println("==========================================");

        System.out.print("Enter Number of Departments : ");

        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {

            graph.add(new ArrayList<>());
        }

        System.out.print("Enter Number of Routes : ");

        int edges = sc.nextInt();

        System.out.println("\nEnter Connected Departments");

        for (int i = 0; i < edges; i++) {

            System.out.print("Enter Route " + (i + 1) + " : ");

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("                 MENU ");
            System.out.println("==========================================");

            System.out.println("1. DFS Traversal");
            System.out.println("2. Find Shortest Route (BFS)");
            System.out.println("3. Display Department Details");
            System.out.println("4. Exit");

            System.out.print("\nEnter Your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                // ================= DFS =================

                case 1:

                    boolean[] visited =
                            new boolean[n + 1];

                    System.out.println("\nDFS Traversal");

                    System.out.print("Traversal Path : ");

                    dfs(1, visited, graph);

                    System.out.println();

                    break;

                // ================= BFS SHORTEST PATH =================

                case 2:

                    int start, destination;

                    System.out.print("\nEnter Starting Department : ");

                    start = sc.nextInt();

                    System.out.print("Enter Destination Department : ");

                    destination = sc.nextInt();

                    shortestPath(start,
                            destination,
                            graph,
                            n);

                    break;

                // ================= DISPLAY =================

                case 3:

                    System.out.println("\nDepartment Details");

                    System.out.println("1 -> Reception");
                    System.out.println("2 -> ICU");
                    System.out.println("3 -> Emergency");
                    System.out.println("4 -> X-Ray");
                    System.out.println("5 -> Pharmacy");

                    break;

                // ================= EXIT =================

                case 4:

                    System.out.println("\nProgram Terminated Successfully");

                    System.exit(0);

                default:

                    System.out.println("\nInvalid Choice");
            }
        }
    }
}

// 5
// 5
// 1 2
// 1 3
// 2 4
// 3 5
// 4 5
// 2
// 1
// 5
// 4

// Shortest Emergency Route

// 1 -> 3 -> 5

// Minimum Departments Crossed : 2


// Real-Time Application
// BFS
// Used in hospitals to find the shortest emergency route between departments.

// Example:


// Reception -> Emergency -> Pharmacy
// DFS
// Used to deeply explore all connected hospital departments.

// Complexity
// Algorithm	Time Complexity
// DFS	O(V + E)
// BFS	O(V + E)