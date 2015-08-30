
// time limit exceed
// 12090 Counting Zeroes
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
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
