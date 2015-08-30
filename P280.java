// Pete and his TAs scrum for finding a bug

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class P280 {

  static Scanner sc = new Scanner(System.in);
  static LinkedList<Integer>[] g;
  static Set<Integer> visited;
  static Set<Integer> reach;

  static void createGraph(int n) {
    g = new LinkedList[n];
    for (int i = 0; i < g.length; i++) {
      g[i] = new LinkedList<>();
    }

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
    int v = sc.nextInt() - 1;
    visited = new HashSet<>();
    reach = new HashSet<>();

    visited.add(v);
    dfs(v);
    System.out.printf("%d", g.length - reach.size());
    for (int j = 0; j < g.length; j++) {
      if (!reach.contains(j)) {
        System.out.printf(" %d", j + 1);
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      createGraph(n);

      int q = sc.nextInt();
      for (int i = 0; i < q; i++) {
        question();
      }
    }
  }
}
