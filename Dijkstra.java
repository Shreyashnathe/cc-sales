import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] g = new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int s = sc.nextInt();

        int[] d = new int[n];
        boolean[] vis = new boolean[n];

        Arrays.fill(d, Integer.MAX_VALUE);

        d[s] = 0;

        for (int c = 0; c < n - 1; c++) {

            int u = -1;
            int mn = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!vis[i] && d[i] < mn) {
                    mn = d[i];
                    u = i;
                }
            }

            vis[u] = true;

            for (int v = 0; v < n; v++) {

                if (!vis[v] && g[u][v] != 0 &&
                        d[u] != Integer.MAX_VALUE &&
                        d[u] + g[u][v] < d[v]) {

                    d[v] = d[u] + g[u][v];
                }
            }
        }

        System.out.println("Shortest distances:");

        for (int i = 0; i < n; i++) {
            System.out.println(s + " -> " + i + " = " + d[i]);
        }
    }
}


// Enter number of vertices: 5

// Enter adjacency matrix:
// 0 10 0 30 100
// 10 0 50 0 0
// 0 50 0 20 10
// 30 0 20 0 60
// 100 0 10 60 0

// Enter source vertex: 0

// Shortest distances:
// 0 -> 0 = 0
// 0 -> 1 = 10
// 0 -> 2 = 50
// 0 -> 3 = 30
// 0 -> 4 = 60