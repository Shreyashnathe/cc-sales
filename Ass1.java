import java.util.*;

public class Ass1 {
  static ArrayList<ArrayList<Integer>> g;
  static boolean[] vis;

  static void dfs(int u){
    vis[u] = true;
    System.out.print(u+" ");
    for(int x : g.get(u)){
      if(!vis[x]) dfs(x);
    }
  }

  static void bfs(int s, int n){
    boolean[] v = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    v[s] = true;
    while(!q.isEmpty()){
      int u = q.poll();
      System.out.print(u+" ");
      for(int x : g.get(u)){
        if(!v[x]){
          v[x] = true;
          q.add(x);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of vetrices :");
    int n = sc.nextInt();
    
    if(n<=0){
      System.out.println("Invalid Graph");
      return;
    }

    g = new ArrayList<>();
    for(int i=0; i<n; i++){
      g.add(new ArrayList<>());
    }

    System.out.print("Enter number of Edges :");
    int e = sc.nextInt();

    for(int i=0; i<e; i++){
      int u = sc.nextInt();
      int v = sc.nextInt();

      if(u<0 || v<0 || u>=n || v>=n) continue;
      if(!g.get(u).contains(v)) g.get(u).add(v);
      if(!g.get(v).contains(u)) g.get(v).add(u);
    }
    vis = new boolean[n];

    System.out.println("DFS Traversal :");
    for(int i=0; i<n; i++){
      if(!vis[i]) dfs(i);
    }

    System.out.println();

    System.out.print("Enter Starting node for BFS :");
    int s = sc.nextInt();

    if(s<0 || s>=n){
      System.out.println("Invalid Input");
      return;
    }

    System.out.println("BFS Traversal :");
    bfs(s, n);
  }  
}
