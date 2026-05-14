import java.util.*;

public class Assignment3 {
    static void ss(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int mi = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[mi]) mi = j;
            }
            int t = a[i];
            a[i] = a[mi];
            a[mi] = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid size");
            return;
        }

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        ss(a, n);

        System.out.println("Sorted array:");
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}

// Enter size: 5
// Enter elements:
// 64 25 12 22 11

// Sorted array:
// 11 12 22 25 64