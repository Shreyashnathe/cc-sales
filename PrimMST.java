import java.util.*;

public class PrimMST {
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

        boolean[] vis = new boolean[n];
        int[] key = new int[n];
        int[] par = new int[n];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        par[0] = -1;

        for (int c = 0; c < n - 1; c++) {

            int u = -1;
            int mn = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!vis[i] && key[i] < mn) {
                    mn = key[i];
                    u = i;
                }
            }

            vis[u] = true;

            for (int v = 0; v < n; v++) {
                if (g[u][v] != 0 && !vis[v] && g[u][v] < key[v]) {
                    key[v] = g[u][v];
                    par[v] = u;
                }
            }
        }

        int cost = 0;

        System.out.println("Edges in MST:");

        for (int i = 1; i < n; i++) {
            System.out.println(par[i] + " - " + i + " : " + g[i][par[i]]);
            cost += g[i][par[i]];
        }

        System.out.println("Total Cost = " + cost);
    }
}

// Enter number of vertices: 4

// Enter adjacency matrix:
// 0 2 0 6
// 2 0 3 8
// 0 3 0 0
// 6 8 0 0

// Edges in MST:
// 0 - 1 : 2
// 1 - 2 : 3
// 0 - 3 : 6

// Total Cost = 11