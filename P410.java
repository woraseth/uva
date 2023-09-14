// time limit

import java.io.*;
import java.util.*;

public class Main {
  static int findPair(int[] a, int n) {
    int i;
    for (i = 0; i < a.length; i++) {
      if (a[i] == n)
        break;
    }
    return a[a.length - 1 - i];
  }

  public static void main(String[] args) throws Exception {
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\in.txt"));
    int id = 1;
    while (true) {
      String line = br.readLine();
      if (line == null || line.trim().length() == 0) break;
 
      String[] tokens = line.split(" ");
      final int c = Integer.parseInt(tokens[0]);
      final int s = Integer.parseInt(tokens[1]);

      line = br.readLine();
      tokens = line.split(" ");
      int[] a = new int[2 * c];
      int[] b = new int[s];
      double avg = 0;
      Set<Integer> set = new LinkedHashSet<Integer>();
      for (int i = 0; i < s; i++) {
        a[i] = Integer.parseInt(tokens[i]);
        b[i] = a[i];
        avg += a[i];
        set.add(a[i]);
      }
      Arrays.sort(a);
      avg /= c;
      double sum = 0;
      for (int i = 0; i < a.length / 2; i++) {
        sum += Math.abs(a[i] + a[a.length - i - 1] - avg);
      }
      if (id > 1)
        System.out.println();
      System.out.printf("Set #%d%n", id++);
      int count = 0;
      for (int i : b) {
        if (set.contains(i)) {
          System.out.printf(" %d: ", count++);
          set.remove(i);
          System.out.printf("%d", i);
          int j = findPair(a, i);
          if (j != 0) {
            set.remove(j);
            System.out.printf(" %d%n", j);
          } else {
            System.out.println();
          }
        }
      }
      while (count < c) {
        System.out.printf(" %d:%n", count++);
      }
      System.out.printf("IMBALANCE = %.5f%n", sum);
    }
    br.close();
  }
}
