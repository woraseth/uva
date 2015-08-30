// time limit exceed

import java.util.Scanner;

public class P12090 {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLong()) {
      long n = sc.nextLong();
      if (n == 0) {
        break;
      }
      long sum = 0;
      for (long b = 2; b <= n / 2; b++) {
        long m = n;
        while (m % b == 0) {
          sum++;
          m /= b;
        }
      }
      sb.append(String.format("%d %d%n", n, sum + 1));   // plus 1 because 16_10 = 10_16
    }
    System.out.print(sb);
  }
}
