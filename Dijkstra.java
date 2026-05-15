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

        // Print Graph
        System.out.println("\nGraph Representation:");

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (g[i][j] != 0) {

                    System.out.println(
                            i + " --(" + g[i][j] + ")--> " + j
                    );
                }
            }
        }

        System.out.print("\nEnter source vertex: ");
        int s = sc.nextInt();

        int[] d = new int[n];
        boolean[] vis = new boolean[n];

        Arrays.fill(d, Integer.MAX_VALUE);

        d[s] = 0;

        // Dijkstra Algorithm
        for (int c = 0; c < n - 1; c++) {

            int u = -1;
            int mn = Integer.MAX_VALUE;

            // Find minimum distance vertex
            for (int i = 0; i < n; i++) {

                if (!vis[i] && d[i] < mn) {

                    mn = d[i];
                    u = i;
                }
            }

            vis[u] = true;

            // Update distances
            for (int v = 0; v < n; v++) {

                if (!vis[v] &&
                        g[u][v] != 0 &&
                        d[u] != Integer.MAX_VALUE &&
                        d[u] + g[u][v] < d[v]) {

                    d[v] = d[u] + g[u][v];
                }
            }
        }

        // Print shortest distances
        System.out.println("\nShortest Distances:");

        for (int i = 0; i < n; i++) {

            System.out.println(
                    s + " --> " + i + " = " + d[i]
            );
        }
    }
}


/*

INPUT

Enter number of vertices: 5

Enter adjacency matrix:
0 10 0 30 100
10 0 50 0 0
0 50 0 20 10
30 0 20 0 60
100 0 10 60 0


GRAPH REPRESENTATION

0 --(10)--> 1
0 --(30)--> 3
0 --(100)--> 4
1 --(50)--> 2
2 --(20)--> 3
2 --(10)--> 4
3 --(60)--> 4


OUTPUT

Enter source vertex: 0

Shortest Distances:

0 --> 0 = 0
0 --> 1 = 10
0 --> 2 = 50
0 --> 3 = 30
0 --> 4 = 60

*/