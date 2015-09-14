// 369 - Combinations
// 0.516 sec
// another method is Binomial Coefficient.

import java.math.BigInteger;
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
      BigInteger c = BigInteger.ONE;
        for (int i = m + 1; i <= n; i++) {
          c = c.multiply(new BigInteger("" + i));
        }
        for (int i = 2; i <= n - m; i++) {
          c = c.divide(new BigInteger("" + i));
        }

      System.out.printf("%d things taken %d at a time is %s exactly.%n", n, m, c.toString());
    }
  }
}
