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

        // Printing Graph
        System.out.println("\nGraph Representation:");

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (g[i][j] != 0) {
                    System.out.println(i + " --(" + g[i][j] + ")--> " + j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int[] key = new int[n];
        int[] par = new int[n];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        par[0] = -1;

        // Prim's Algorithm
        for (int c = 0; c < n - 1; c++) {

            int u = -1;
            int mn = Integer.MAX_VALUE;

            // Find minimum key vertex
            for (int i = 0; i < n; i++) {

                if (!vis[i] && key[i] < mn) {
                    mn = key[i];
                    u = i;
                }
            }

            vis[u] = true;

            // Update adjacent vertices
            for (int v = 0; v < n; v++) {

                if (g[u][v] != 0 &&
                        !vis[v] &&
                        g[u][v] < key[v]) {

                    key[v] = g[u][v];
                    par[v] = u;
                }
            }
        }

        int cost = 0;

        System.out.println("\nEdges in MST:");

        for (int i = 1; i < n; i++) {

            System.out.println(
                    par[i] + " --(" + g[i][par[i]] + ")--> " + i
            );

            cost += g[i][par[i]];
        }

        System.out.println("\nTotal Cost = " + cost);
    }
}


/*
INPUT

Enter number of vertices: 4

Enter adjacency matrix:
0 2 0 6
2 0 3 8
0 3 0 0
6 8 0 0


OUTPUT

Graph Representation:
0 --(2)--> 1
0 --(6)--> 3
1 --(3)--> 2
1 --(8)--> 3

Edges in MST:
0 --(2)--> 1
1 --(3)--> 2
0 --(6)--> 3

Total Cost = 11
*/