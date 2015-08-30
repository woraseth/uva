
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class P280 {

  static Scanner sc;
  static LinkedList<Integer>[] g;

  static void createGraph() {
    while (true) {
      int v = sc.nextInt();
      if (v == 0) {
        break;
      }

      while (true) {
        int u = sc.nextInt();
        if (u == 0) {
          break;
        }
        g[v - 1].add(u - 1);
      }
    }
  }

  static Set<Integer> visited = new HashSet<>();
  static Set<Integer> reach = new HashSet<>();

  static void unreachable(int v) {
    visited = new HashSet<>();
    reach = new HashSet<>();
    dfs(v);
  }

  static void dfs(int v) {
    for (int i = 0; i < g[v].size(); i++) {
      int u = g[v].get(i);
      reach.add(u);
      if (!visited.contains(u)) {
        visited.add(u);
        dfs(u);
      }
    }
  }

  static void question() {
    unreachable(sc.nextInt() - 1);
    System.out.printf("%d ", g.length - reach.size());
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < g.length; j++) {
      if (!reach.contains(j)) {
        sb.append(j + 1);
        sb.append(" ");
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
  }


  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int n = sc.nextInt();
    g = new LinkedList[n];
    for (int i = 0; i < g.length; i++) {
      g[i] = new LinkedList<>();
    }
    createGraph();
//    for (int i = 0; i < g.length; i++) {
//      System.out.println(g[i]);
//    }

    while (true) {
      int q = sc.nextInt();
      if (q == 0) {
        break;
      }
      for (int i = 0; i < q; i++) {
        question();
      }
    }
  }
}
