import java.util.*;

public class Assignment4 {
    static int n, cnt;
    static int[] b;
    static boolean[] c, d1, d2;

    static void pr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void go(int r) {
        if (r == n) {
            cnt++;
            pr();
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!c[j] && !d1[r + j] && !d2[r - j + n - 1]) {
                b[r] = j;
                c[j] = d1[r + j] = d2[r - j + n - 1] = true;
                go(r + 1);
                c[j] = d1[r + j] = d2[r - j + n - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input");
            return;
        }
        if (n == 2 || n == 3) {
            System.out.println("No solution exists");
            return;
        }

        b = new int[n];
        c = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];
        cnt = 0;

        System.out.println("Solutions:");
        go(0);
        System.out.println("Total solutions: " + cnt);
    }
}

// Enter n: 4

// . Q . . 
// . . . Q 
// Q . . . 
// . . Q . 

// . . Q . 
// Q . . . 
// . . . Q 
// . Q . . 
// Total solutions: 2