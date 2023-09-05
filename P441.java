// UVa 441 Lotto

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    // sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    int n = sc.nextInt();
    while (true) {
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
          x[i] = sc.nextInt();
      }

      for (int a = 0  ; a < n; a++) 
      for (int b = a+1; b < n; b++) 
      for (int c = b+1; c < n; c++) 
      for (int d = c+1; d < n; d++) 
      for (int e = d+1; e < n; e++) 
      for (int f = e+1; f < n; f++) 
        System.out.printf("%d %d %d %d %d %d%n", x[a],x[b],x[c],x[d],x[e],x[f]);

      n = sc.nextInt();
      if (n == 0) break;
      System.out.println();
    }
  }
}
