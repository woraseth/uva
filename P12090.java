
// time limit exceed
// 12090 Counting Zeroes
// by Shahriar Manzoor
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
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
      System.out.printf("%d %d%n",  n, sum + 1);  
    }
  }
}
