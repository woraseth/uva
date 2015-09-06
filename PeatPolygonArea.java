// D polygon area
// Determinant 

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int tt = 0; tt < test; tt++) {
      int n = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n + 1];
      for (int i = 0; i < n; i++) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }
      x[n] = x[0];
      y[n] = y[0];
//      System.out.println(java.util.Arrays.toString(x));
      double a = 0;
      for (int i = 0; i < n; i++) {
        a += x[i] * y[i + 1];
      }
//      System.out.println(a);
      double b = 0;
      for (int i = 1; i <= n; i++) {
        b += x[i] * y[i - 1];
      }
//      System.out.println(b);
      System.out.printf("%.3f%n", (double) Math.abs(a - b) / 2);
    }

  }
}


