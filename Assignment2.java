import java.util.*;

class Node {
    int x, y, g, h, f;
    Node p;

    Node(int x, int y, int g, int h, Node p) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.p = p;
    }
}

public class Assignment2 {
    static int n, m;
    static int[][] grid;
    static boolean[][] vis;

    static int h(int x, int y, int tx, int ty) {
        return Math.abs(x - tx) + Math.abs(y - ty);
    }

    static void print(Node t) {
        List<int[]> path = new ArrayList<>();
        while (t != null) {
            path.add(new int[]{t.x, t.y});
            t = t.p;
        }
        Collections.reverse(path);
        for (int[] p : path) {
            System.out.print("(" + p[0] + "," + p[1] + ") ");
        }
    }

    static void aStar(int sx, int sy, int tx, int ty) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));
        vis = new boolean[n][m];

        pq.add(new Node(sx, sy, 0, h(sx, sy, tx, ty), null));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (vis[cur.x][cur.y]) continue;
            vis[cur.x][cur.y] = true;

            if (cur.x == tx && cur.y == ty) {
                System.out.println("Path found:");
                print(cur);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0 && !vis[nx][ny]) {
                    int ng = cur.g + 1;
                    int nh = h(nx, ny, tx, ty);
                    pq.add(new Node(nx, ny, ng, nh, cur));
                }
            }
        }

        System.out.println("No path exists");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and cols: ");
        n = sc.nextInt();
        m = sc.nextInt();

        if (n <= 0 || m <= 0) {
            System.out.println("Invalid grid");
            return;
        }

        grid = new int[n][m];

        System.out.println("Enter grid (0=free, 1=blocked):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter start (x y): ");
        int sx = sc.nextInt();
        int sy = sc.nextInt();

        System.out.print("Enter goal (x y): ");
        int tx = sc.nextInt();
        int ty = sc.nextInt();

        if (sx < 0 || sy < 0 || tx < 0 || ty < 0 || sx >= n || sy >= m || tx >= n || ty >= m) {
            System.out.println("Invalid coordinates");
            return;
        }

        if (grid[sx][sy] == 1 || grid[tx][ty] == 1) {
            System.out.println("Start or goal blocked");
            return;
        }

        aStar(sx, sy, tx, ty);
    }
}


// Enter rows and cols: 5 5
// Enter grid:
// 0 0 0 0 1
// 1 1 0 1 0
// 0 0 0 0 0
// 0 1 1 1 0
// 0 0 0 0 0
// Enter start: 0 0
// Enter goal: 4 4

// Path found:
// (0,0) (0,1) (0,2) (1,2) (2,2) (2,3) (2,4) (3,4) (4,4)