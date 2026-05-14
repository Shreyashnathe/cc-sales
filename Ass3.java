
import java.util.Scanner;

public class Ass3{

  static void ss(int a[], int n){
    for(int i=0; i<n-1; i++){
      int mi = i;
      for(int j=i+1; j<n; j++){
        if(a[j] < a[mi]) mi = j;
      }
      int t = a[i];
      a[i] = a[mi];
      a[mi] = t;
    }
  }
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of Elements :");
    int n = sc.nextInt();

    if(n<=0){
      System.out.println("INvalid Input");
      return;
    }

    int[] arr = new int[n];

    System.out.println("Enter Elements :");
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }

    ss(arr, n);

    System.out.println("Sorted Array :");
    for(int x : arr){
      System.out.println(x);
    }
  }
}