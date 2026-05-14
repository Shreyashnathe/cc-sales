import java.util.*;

public class Assignment1 {
    static ArrayList<ArrayList<Integer>> g;
    static boolean[] vis;

    static void dfs(int u) {
        vis[u] = true;
        System.out.print(u + " ");
        for (int v : g.get(u)) {
            if (!vis[v]) dfs(v);
        }
    }

    static void bfs(int s, int n) {
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        v[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int x : g.get(u)) {
                if (!v[x]) {
                    v[x] = true;
                    q.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid graph");
            return;
        }

        g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u < 0 || v < 0 || u >= n || v >= n) continue;

            if (!g.get(u).contains(v)) g.get(u).add(v);
            if (!g.get(v).contains(u)) g.get(v).add(u);
        }

        vis = new boolean[n];

        System.out.println("DFS Traversal:");
        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i);
        }

        System.out.println();

        System.out.print("Enter start vertex for BFS: ");
        int s = sc.nextInt();

        if (s < 0 || s >= n) {
            System.out.println("Invalid start");
            return;
        }

        System.out.println("BFS Traversal:");
        bfs(s, n);
    }
}

// Enter number of vertices: 5
// Enter number of edges: 4
// 0 1
// 0 2
// 1 3
// 3 4
// Enter start vertex for BFS: 0

// DFS Traversal:
// 0 1 3 4 2
// BFS Traversal:
// 0 1 2 3 4