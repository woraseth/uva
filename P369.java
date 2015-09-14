// 369 - Combinations
// WA
// another method is Binomial Coefficient.

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      if (n == 0 && m == 0) {
        break;
      }
      long c = 1;
      if (m > n / 2) {
        for (int i = m + 1; i <= n; i++) {
          c *= i;
        }
        for (int i = 2; i <= n - m; i++) {
          c /= i;
        }
      } else {
        for (int i = n - m + 1; i <= n; i++) {
          c *= i;
        }
        for (int i = 2; i <= m; i++) {
          c /= i;
        }
      }

      System.out.printf("%d things taken %d at a time is %d exactly.%n", n, m, c);
    }
  }
}
