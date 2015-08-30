

import java.util.Scanner;

public class P12090 {

  static int fzero(long n, long b) {
    int c = 0;
    while (n % b == 0) {
      c++;
      n /= b;
    }
    return c;
  }

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLong()) {
      long n = sc.nextLong();
      if (n == 0) {
        break;
      }
      long sum = 0;
      long b = 2;
      for (long i = 2; i <= n / 2; i++) {
        int z = fzero(n, b);
//        System.out.printf("%d %d %d%n", n, b, z);
        sum += z;
        b++;
      }
      sb.append(String.format("%d %d%n", n, sum + 1));   // why plus 1
    }
    System.out.print(sb);
  }
}
