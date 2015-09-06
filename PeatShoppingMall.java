// H. Shopping Mall
// greedy

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int tt = 0; tt < test; tt++) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; i++) {
        x[i] = sc.nextInt();
      }
      Arrays.sort(x);
      int sum = 0;
      for (int i = 0; i < x.length; i++) {
        sum += x[i];
      }
      int index = n - 2;
      while (n >= 4) {
        sum -= x[index];
        index -= 2;
        n -= 4;
      }
      System.out.println(sum);
    }

  }
}
